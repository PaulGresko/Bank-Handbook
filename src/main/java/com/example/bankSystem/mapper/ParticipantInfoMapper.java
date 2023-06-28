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
    private final RstrListMapper rstrListMapper;

    @Autowired
    public ParticipantInfoMapper(ModelMapper modelMapper, RstrListMapper rstrListMapper) {
        this.modelMapper = modelMapper;
        this.rstrListMapper = rstrListMapper;
    }

    public ParticipantInfoDto toDto(ParticipantInfo participantInfo){

        ParticipantInfoDto participantInfoDto = modelMapper.map(participantInfo,ParticipantInfoDto.class);
        participantInfoDto.setRstrLists(rstrListMapper.toDtoList(participantInfo.getRstrLists()));

        return participantInfoDto;
    }

    public List<ParticipantInfoDto> toDtoList(List<ParticipantInfo> participantInfoList){
        return participantInfoList.stream().map(this::toDto).collect(Collectors.toList());
    }

    public ParticipantInfo toModel(ParticipantInfoDto participantInfoDto){

        ParticipantInfo participantInfo = modelMapper.map(participantInfoDto,ParticipantInfo.class);
        participantInfo.setRstrLists(rstrListMapper.toModelList(participantInfoDto.getRstrLists()));

        return participantInfo;
    }
    public List<ParticipantInfo> toModelList(List<ParticipantInfoDto> participantInfoDtoList){
        return participantInfoDtoList.stream().map(this::toModel).collect(Collectors.toList());
    }

}
