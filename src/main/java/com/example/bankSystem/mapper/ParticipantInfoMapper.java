package com.example.bankSystem.mapper;

import com.example.bankSystem.dto.ParticipantInfoDto;
import com.example.bankSystem.enums.ParticipantStatus;
import com.example.bankSystem.models.bankModels.ParticipantInfo;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class ParticipantInfoMapper {
    private final ModelMapper modelMapper;

    @Autowired
    public ParticipantInfoMapper(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }

    public ParticipantInfoDto toDto(Object[] objects){
        ParticipantInfoDto dto = new ParticipantInfoDto();
        dto.setId((Long) objects[0]);
        dto.setEd807Id((Long) objects[1]);
        dto.setBic((String) objects[2]);
        dto.setNameP((String) objects[3]);
        dto.setEnglName((String) objects[4]);
        dto.setRegN((String) objects[5]);
        dto.setCntrCd((String) objects[6]);
        dto.setRgn((String) objects[7]);
        dto.setInd((String) objects[8]);
        dto.setTnp((String) objects[9]);
        dto.setNnp((String) objects[10]);
        dto.setAdr((String) objects[11]);
        dto.setPrntBIC((String) objects[12]);
        dto.setDateIn((Date) objects[13]);
        dto.setDateOut((Date) objects[14]);
        dto.setPtType((String) objects[15]);
        dto.setSrvcs((String) objects[16]);
        dto.setXchType((Boolean) objects[17]);
        dto.setUid((String) objects[18]);
        dto.setParticipantStatus(ParticipantStatus.valueOf((String) objects[19]));
        return dto;
    }

    public List<ParticipantInfoDto> toDtoList(List<Object[]> participantInfoList){
        return participantInfoList.stream().map(this::toDto).collect(Collectors.toList());
    }


}
