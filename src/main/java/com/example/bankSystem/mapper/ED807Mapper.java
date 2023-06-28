package com.example.bankSystem.mapper;

import com.example.bankSystem.dto.ED807Dto;
import com.example.bankSystem.models.bankModels.ED807;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class ED807Mapper {

    private final ModelMapper modelMapper;
    private final BICDirectoryEntryMapper entryMapper;

    @Autowired
    public ED807Mapper(ModelMapper modelMapper, BICDirectoryEntryMapper entryMapper) {
        this.modelMapper = modelMapper;
        this.entryMapper = entryMapper;
    }

    public ED807Dto toDto(ED807 ed807){
        ED807Dto ed807Dto = modelMapper.map(ed807,ED807Dto.class);
        ed807Dto.setBicDirectoryEntries(entryMapper.toDtoList(ed807.getBicDirectoryEntries()));
        return new ED807Dto();
    }
    public List<ED807Dto> toDtoList(List<ED807> ed807List){
        return ed807List.stream().map(this::toDto).collect(Collectors.toList());
    }


    public ED807 toModel(ED807Dto ed807Dto){
        ED807 ed807 = modelMapper.map(ed807Dto, ED807.class);
        ed807.setBicDirectoryEntries(entryMapper.toModelList(ed807Dto.getBicDirectoryEntries()));
        return ed807;
    }
    public List<ED807> toModelList(List<ED807Dto> ed807DtoList){
        return ed807DtoList.stream().map(this::toModel).collect(Collectors.toList());
    }








}
