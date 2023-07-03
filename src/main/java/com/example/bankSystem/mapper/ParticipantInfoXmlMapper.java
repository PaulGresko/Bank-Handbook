package com.example.bankSystem.mapper;

import com.example.bankSystem.dto.parseXml.ParticipantInfoXml;
import com.example.bankSystem.models.bankModels.ParticipantInfo;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class ParticipantInfoXmlMapper {


    private final ModelMapper modelMapper;
    private final RstrListXmlMapper rstrListXmlMapper;

    @Autowired
    public ParticipantInfoXmlMapper(ModelMapper modelMapper, RstrListXmlMapper rstrListXmlMapper) {
        this.modelMapper = modelMapper;
        this.rstrListXmlMapper = rstrListXmlMapper;
    }

    public ParticipantInfoXml toDto(ParticipantInfo participantInfo){

        ParticipantInfoXml participantInfoXml = modelMapper.map(participantInfo, ParticipantInfoXml.class);
        participantInfoXml.setRstrLists(rstrListXmlMapper.toDtoList(participantInfo.getRstrLists()));

        return participantInfoXml;
    }

    public List<ParticipantInfoXml> toDtoList(List<ParticipantInfo> participantInfoList){
        return participantInfoList.stream().map(this::toDto).collect(Collectors.toList());
    }

    public ParticipantInfo toModel(ParticipantInfoXml participantInfoXml){

        ParticipantInfo participantInfo = modelMapper.map(participantInfoXml,ParticipantInfo.class);
        participantInfo.setRstrLists(rstrListXmlMapper.toModelList(participantInfoXml.getRstrLists()));

        return participantInfo;
    }
    public List<ParticipantInfo> toModelList(List<ParticipantInfoXml> participantInfoXmlList){
        return participantInfoXmlList.stream().map(this::toModel).collect(Collectors.toList());
    }

}
