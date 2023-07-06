package com.example.bankSystem.mapper.xml;


import com.example.bankSystem.dto.xml.AccRstrListXml;
import com.example.bankSystem.models.bankModels.AccRstrList;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class AccRstrListXmlMapper {

    private final ModelMapper modelMapper;

    @Autowired
    public AccRstrListXmlMapper(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }

    public AccRstrListXml toDto(AccRstrList accRstrList){
        return modelMapper.map(accRstrList, AccRstrListXml.class);
    }
    public List<AccRstrListXml> toDtoList(List<AccRstrList> accRstrLists){
        return accRstrLists.stream().map(this::toDto).collect(Collectors.toList());
    }

    public AccRstrList toModel(AccRstrListXml accRstrListXml) {
        return modelMapper.map(accRstrListXml, AccRstrList.class);
    }
    public List<AccRstrList> toModelList(List<AccRstrListXml> accRstrListXmls){
        return accRstrListXmls.stream().map(this::toModel).collect(Collectors.toList());
    }
}
