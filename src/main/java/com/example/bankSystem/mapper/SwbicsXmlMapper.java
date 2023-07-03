package com.example.bankSystem.mapper;


import com.example.bankSystem.dto.parseXml.SwbicsXml;
import com.example.bankSystem.models.bankModels.Swbics;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class SwbicsXmlMapper {
    private final ModelMapper modelMapper;

    @Autowired
    public SwbicsXmlMapper(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }

    public SwbicsXml toDto(Swbics swbics){
        return modelMapper.map(swbics, SwbicsXml.class);
    }

    public List<SwbicsXml> toDtoList(List<Swbics> swbicsList){
        return swbicsList.stream().map(this::toDto).collect(Collectors.toList());
    }

    public Swbics toModel(SwbicsXml swbicsXml){
        return modelMapper.map(swbicsXml, Swbics.class);
    }

    public List<Swbics> toModelList(List<SwbicsXml> swbicsXmlList){
        return swbicsXmlList.stream().map(this::toModel).collect(Collectors.toList());
    }
}
