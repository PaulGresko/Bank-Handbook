package com.example.bankSystem.mapper;


import com.example.bankSystem.dto.parseXml.BICDirectoryEntryXml;
import com.example.bankSystem.models.bankModels.BICDirectoryEntry;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class BICDirectoryEntryXmlMapper {

    private final ParticipantInfoXmlMapper participantInfoXmlMapper;
    private final AccountXmlMapper accountXmlMapper;
    private final SwbicsXmlMapper swbicsXmlMapper;

    @Autowired
    public BICDirectoryEntryXmlMapper(ParticipantInfoXmlMapper participantInfoXmlMapper, AccountXmlMapper accountXmlMapper, SwbicsXmlMapper swbicsXmlMapper) {
        this.participantInfoXmlMapper = participantInfoXmlMapper;
        this.accountXmlMapper = accountXmlMapper;
        this.swbicsXmlMapper = swbicsXmlMapper;
    }

    public BICDirectoryEntryXml toDto(BICDirectoryEntry entry){
        BICDirectoryEntryXml entryDto = new BICDirectoryEntryXml();
        entryDto.setBic(entry.getBic());
        entryDto.setParticipantInfo(participantInfoXmlMapper.toDto(entry.getParticipantInfo()));
        entryDto.setAccounts(accountXmlMapper.toDtoList(entry.getAccounts()));
        if(entry.getSwbics()!= null) entryDto.setSwbics(swbicsXmlMapper.toDto(entry.getSwbics()));
        return entryDto;
    }

    public List<BICDirectoryEntryXml> toDtoList(List<BICDirectoryEntry> entryList){
        return entryList.stream().map(this::toDto).collect(Collectors.toList());
    }

    public BICDirectoryEntry toModel(BICDirectoryEntryXml entryDto){
        BICDirectoryEntry entry = new BICDirectoryEntry();
        entry.setBic(entryDto.getBic());
        entry.setParticipantInfo(participantInfoXmlMapper.toModel(entryDto.getParticipantInfo()));
        entry.setAccounts(accountXmlMapper.toModelList(entryDto.getAccounts()));
        if(entryDto.getSwbics() != null) entry.setSwbics(swbicsXmlMapper.toModel(entryDto.getSwbics()));
        return entry;
    }

    public List<BICDirectoryEntry> toModelList(List<BICDirectoryEntryXml> entryDtoList){
        return entryDtoList.stream().map(this::toModel).collect(Collectors.toList());
    }

}
