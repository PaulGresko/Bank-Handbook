package com.example.bankSystem.mapper;

import com.example.bankSystem.dto.parseXml.RstrListXml;
import com.example.bankSystem.models.bankModels.RstrList;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class RstrListXmlMapper {

    private final ModelMapper modelMapper;

    @Autowired
    public RstrListXmlMapper(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }

    public RstrListXml toDto(RstrList rstrList){
        return modelMapper.map(rstrList, RstrListXml.class);
    }
    public List<RstrListXml> toDtoList(List<RstrList> rstrLists){
        return rstrLists.stream().map(this::toDto).collect(Collectors.toList());
    }

    public RstrList toModel(RstrListXml rstrListXml){
        return modelMapper.map(rstrListXml, RstrList.class);
    }

    public List<RstrList> toModelList(List<RstrListXml> rstrListXmls){
        return rstrListXmls.stream().map(this::toModel).collect(Collectors.toList());
    }

}
