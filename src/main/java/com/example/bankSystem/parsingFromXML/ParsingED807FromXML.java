package com.example.bankSystem.parsingFromXML;



import com.example.bankSystem.dto.ED807Dto;
import com.example.bankSystem.models.bankModels.*;
import jakarta.xml.bind.JAXBContext;
import jakarta.xml.bind.JAXBException;
import jakarta.xml.bind.Unmarshaller;


import java.io.File;

public class ParsingED807FromXML {

    public static ED807Dto parse(String filename) throws JAXBException {
        JAXBContext jaxbContext = JAXBContext.newInstance(ED807Dto.class);

        Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();

        //        List<BICDirectoryEntry> bicDirectoryEntries = ed807.getBicDirectoryEntries();
//        if (!bicDirectoryEntries.isEmpty()) {
//            for (BICDirectoryEntry entry : bicDirectoryEntries) {
//                entry.setEd807(ed807);
//
//                if(entry.getParticipantInfo() != null) {
//                    entry.getParticipantInfo().setBicDirectoryEntry(entry);
//
//                    if(!entry.getParticipantInfo().getRstrLists().isEmpty()){
//                        List<RstrList> rstrLists = entry.getParticipantInfo().getRstrLists();
//                        for(RstrList rstrList: rstrLists){
//                            rstrList.setParticipantInfo(entry.getParticipantInfo());
//                        }
//                        entry.getParticipantInfo().setRstrLists(rstrLists);
//                    }
//                }
//                if(entry.getSwbics() != null){
//                    entry.getSwbics().setBicDirectoryEntry(entry);
//                }
//                if(!entry.getAccounts().isEmpty()){
//                    List<Account> accounts = entry.getAccounts();
//                    for(Account account : accounts){
//                        account.setBicDirectoryEntry(entry);
//                        if(!account.getAccRstrLists().isEmpty()){
//                            List<AccRstrList> accRstrLists = account.getAccRstrLists();
//
//                            for(AccRstrList accRstrList: accRstrLists){
//                                accRstrList.setAccount(account);
//                            }
//                            account.setAccRstrLists(accRstrLists);
//                        }
//                    }
//                    entry.setAccounts(accounts);
//                }
//            }
//        }
//        ed807.setBicDirectoryEntries(bicDirectoryEntries);

        return (ED807Dto) unmarshaller.unmarshal(new File(filename));
    }
}
