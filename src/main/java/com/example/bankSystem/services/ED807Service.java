package com.example.bankSystem.services;



import com.example.bankSystem.dto.parseXml.ED807Xml;
import com.example.bankSystem.mapper.ED807Mapper;
import com.example.bankSystem.mapper.ED807XmlMapper;
import com.example.bankSystem.models.bankModels.*;
import com.example.bankSystem.repositories.ED807Repository;
import jakarta.xml.bind.JAXBContext;
import jakarta.xml.bind.JAXBException;
import jakarta.xml.bind.Unmarshaller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.File;
import java.util.List;
import java.util.NoSuchElementException;

@Service
public class ED807Service {

    private final ED807Repository ed807Repository;
    private final ED807XmlMapper ed807XmlMapper;
    private final ED807Mapper ed807Mapper;


    @Autowired
    public ED807Service(ED807Repository ed807Repository, ED807XmlMapper ed807XmlMapper, ED807Mapper ed807Mapper) {
        this.ed807Repository = ed807Repository;
        this.ed807XmlMapper = ed807XmlMapper;
        this.ed807Mapper = ed807Mapper;
    }

    @Transactional
    public ED807Xml parse(String filename) throws JAXBException {
        ED807Xml ed807 = parseFromFile(new File(filename));
        ed807Repository.save(saveElements(ed807XmlMapper.toModel(ed807)));
        return ed807;
    }

    public List<ED807> getAll(int page){
        return ed807Repository.findAll(PageRequest.of(page,20)).getContent();
    }
    public ED807 getOne(Long id){
        return ed807Repository.findById(id).orElseThrow(()-> new NoSuchElementException("ED807 not found"));
    }


    @Transactional
    public ED807 update(Long id, ED807 ed807){
        ed807.setId(id);
        return ed807Repository.save(ed807);
    }

    @Transactional
    public void delete(Long id){
        ED807 ed807 = ed807Repository.findById(id).orElseThrow(()-> new NoSuchElementException("ED807 not found"));
        ed807.setDeleted(true);
        ed807Repository.save(ed807);
    }

    @Transactional
    public void recover(Long id){
        ED807 ed807 = ed807Repository.findById(id).orElseThrow(()-> new NoSuchElementException("ED807 not found"));
        ed807.setDeleted(false);
        ed807Repository.save(ed807);
    }

    public Long getCount(){
       return ed807Repository.count();
    }

    public ED807Xml parseFromFile(File file) throws JAXBException {
        JAXBContext jaxbContext = JAXBContext.newInstance(ED807Xml.class);
        Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();
        ED807Xml ed807Xml = (ED807Xml) unmarshaller.unmarshal(file);
        ed807Xml.setFileName(file.getName());
        return ed807Xml;
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
