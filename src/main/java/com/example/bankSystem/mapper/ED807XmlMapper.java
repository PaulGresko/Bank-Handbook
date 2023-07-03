package com.example.bankSystem.mapper;

import com.example.bankSystem.dto.parseXml.ED807Xml;
import com.example.bankSystem.models.bankModels.ED807;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeMap;
import org.modelmapper.spi.DestinationSetter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class ED807XmlMapper {

    private final ModelMapper modelMapper;
    private final BICDirectoryEntryXmlMapper entryMapper;

    @Autowired
    public ED807XmlMapper(ModelMapper modelMapper, BICDirectoryEntryXmlMapper entryMapper) {
        this.modelMapper = modelMapper;
        this.entryMapper = entryMapper;
    }

    public ED807Xml toDto(ED807 ed807){
        ED807Xml ed807Xml = modelMapper.map(ed807, ED807Xml.class);
        ed807Xml.setBicDirectoryEntries(entryMapper.toDtoList(ed807.getBicDirectoryEntries()));
        return new ED807Xml();
    }
    public List<ED807Xml> toDtoList(List<ED807> ed807List){
        return ed807List.stream().map(this::toDto).collect(Collectors.toList());
    }


    public ED807 toModel(ED807Xml ed807Xml){
        ED807 ed807 = modelMapper.map(ed807Xml, ED807.class);
        ed807.setBicDirectoryEntries(entryMapper.toModelList(ed807Xml.getBicDirectoryEntries()));
        return ed807;
    }
    public List<ED807> toModelList(List<ED807Xml> ed807XmlList){
        return ed807XmlList.stream().map(this::toModel).collect(Collectors.toList());
    }








}
