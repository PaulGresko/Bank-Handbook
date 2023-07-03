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

    @Autowired
    public ED807Mapper(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }

    public ED807Dto toDto(ED807 ed807){
        return modelMapper.map(ed807, ED807Dto.class);
    }

    public List<ED807Dto> toDtoList(List<ED807> ed807List){
        return ed807List.stream().map(this::toDto).collect(Collectors.toList());
    }

}
