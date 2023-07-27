package com.example.bankSystem.parser;

import com.example.bankSystem.dto.xml.ED807Xml;
import com.example.bankSystem.mapper.xml.ED807XmlMapper;
import com.example.bankSystem.models.bankModels.*;
import jakarta.xml.bind.JAXBContext;
import jakarta.xml.bind.JAXBException;
import jakarta.xml.bind.Unmarshaller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;
import java.util.Optional;

@Component
public class Parser {


    private final ED807XmlMapper mapper;


    @Autowired
    public Parser(ED807XmlMapper mapper) {
        this.mapper = mapper;
    }


    public ED807 actualization(Optional<String> title) {
        try {
            File zipFile = DownloadFile.download();
            File extractedXmlFile = DownloadFile.unzipFile(zipFile);
            return parse(extractedXmlFile, title.orElse(extractedXmlFile.getName()));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    public ED807 parse(File file, String title){
        ED807Xml ed807Xml;
        try {
            JAXBContext jaxbContext = JAXBContext.newInstance(ED807Xml.class);
            Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();
            ed807Xml = (ED807Xml) unmarshaller.unmarshal(file);
            ed807Xml.setFileName(file.getName());
            ed807Xml.setTitle(title);
            return saveElements(mapper.toModel(ed807Xml));
        } catch (JAXBException e) {
            System.out.println(e.getMessage());
        }
        return null;

    }
    public ED807 parse(MultipartFile file, Optional<String> title) throws IOException {

         ED807 ed807 = parse(convertMultipartFileToFile(file), title.orElse(file.getOriginalFilename()));
         ed807.setFileName(file.getOriginalFilename());
         return ed807;
    }

    public File convertMultipartFileToFile(MultipartFile multipartFile) throws IOException {
        File convertedFile = File.createTempFile("converted_",  null);
        try (FileOutputStream fileOutputStream = new FileOutputStream(convertedFile)) {
            fileOutputStream.write(multipartFile.getBytes());
        } catch (IOException e){
            System.out.println(e.getMessage());
        }
        return convertedFile;
    }

    public ED807 saveElements(ED807 ed807){
        List<BICDirectoryEntry> bicDirectoryEntries = ed807.getBicDirectoryEntries();
        if (!bicDirectoryEntries.isEmpty()) {
            for (BICDirectoryEntry entry : bicDirectoryEntries) {
                entry.setEd807(ed807);
                if(entry.getParticipantInfo() != null) {
                    entry.getParticipantInfo().setBicDirectoryEntry(entry);
                    if(!entry.getParticipantInfo().getRstrLists().isEmpty()){
                        List<RstrList> rstrLists = entry.getParticipantInfo().getRstrLists();
                        for(RstrList rstrList: rstrLists){
                            rstrList.setParticipantInfo(entry.getParticipantInfo());
                        }
                    }
                }
                if(entry.getSwbics() != null){
                    entry.getSwbics().setBicDirectoryEntry(entry);
                }
                if(!entry.getAccounts().isEmpty()){
                    List<Account> accounts = entry.getAccounts();
                    for(Account account : accounts){
                        account.setBicDirectoryEntry(entry);
                        if(!account.getAccRstrLists().isEmpty()){
                            List<AccRstrList> accRstrLists = account.getAccRstrLists();
                            for(AccRstrList accRstrList: accRstrLists){
                                accRstrList.setAccount(account);
                            }
                        }
                    }
                }
            }
        }
        return ed807;
    }
}
