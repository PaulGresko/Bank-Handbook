package com.example.bankSystem.mapper;


import com.example.bankSystem.dto.BICDirectoryEntryDto;
import com.example.bankSystem.models.bankModels.BICDirectoryEntry;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class BICDirectoryEntryMapper {

    private final ParticipantInfoMapper participantInfoMapper;
    private final AccountMapper accountMapper;
    private final SwbicsMapper swbicsMapper;

    @Autowired
    public BICDirectoryEntryMapper(ParticipantInfoMapper participantInfoMapper, AccountMapper accountMapper, SwbicsMapper swbicsMapper) {
        this.participantInfoMapper = participantInfoMapper;
        this.accountMapper = accountMapper;
        this.swbicsMapper = swbicsMapper;
    }

    public BICDirectoryEntryDto toDto(BICDirectoryEntry entry){
        BICDirectoryEntryDto entryDto = new BICDirectoryEntryDto();
        entryDto.setBic(entry.getBic());
        entryDto.setParticipantInfo(participantInfoMapper.toDto(entry.getParticipantInfo()));
        entryDto.setAccounts(accountMapper.toDtoList(entry.getAccounts()));
        if(entry.getSwbics()!= null) entryDto.setSwbics(swbicsMapper.toDto(entry.getSwbics()));
        return entryDto;
    }

    public List<BICDirectoryEntryDto> toDtoList(List<BICDirectoryEntry> entryList){
        return entryList.stream().map(this::toDto).collect(Collectors.toList());
    }

    public BICDirectoryEntry toModel(BICDirectoryEntryDto entryDto){
        BICDirectoryEntry entry = new BICDirectoryEntry();
        entry.setBic(entryDto.getBic());
        entry.setParticipantInfo(participantInfoMapper.toModel(entryDto.getParticipantInfo()));
        entry.setAccounts(accountMapper.toModelList(entryDto.getAccounts()));
        if(entryDto.getSwbics() != null) entry.setSwbics(swbicsMapper.toModel(entryDto.getSwbics()));
        return entry;
    }

    public List<BICDirectoryEntry> toModelList(List<BICDirectoryEntryDto> entryDtoList){
        return entryDtoList.stream().map(this::toModel).collect(Collectors.toList());
    }

}
