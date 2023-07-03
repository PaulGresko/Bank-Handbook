package com.example.bankSystem.mapper;

import com.example.bankSystem.dto.ParticipantInfoDto;
import com.example.bankSystem.models.bankModels.ParticipantInfo;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class ParticipantInfoMapper {
    private final ModelMapper modelMapper;

    @Autowired
    public ParticipantInfoMapper(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }

    public ParticipantInfoDto toDto(ParticipantInfo participantInfo){
        ParticipantInfoDto dto = modelMapper.map(participantInfo, ParticipantInfoDto.class);
        dto.setEd807Id(participantInfo.getBicDirectoryEntry().getEd807().getId());
        dto.setBic(participantInfo.getBicDirectoryEntry().getBic());
        return dto;
    }

    public List<ParticipantInfoDto> toDtoList(List<ParticipantInfo> participantInfoList){
        return participantInfoList.stream().map(this::toDto).collect(Collectors.toList());
    }


}
