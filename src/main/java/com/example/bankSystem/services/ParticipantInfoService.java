package com.example.bankSystem.services;

import com.example.bankSystem.dto.ParticipantInfoDto;
import com.example.bankSystem.mapper.ParticipantInfoMapper;
import com.example.bankSystem.repositories.ParticipantInfoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ParticipantInfoService {

    private final ParticipantInfoRepository participantInfoRepository;
    private final ParticipantInfoMapper mapper;

    @Autowired
    public ParticipantInfoService(ParticipantInfoRepository participantInfoRepository, ParticipantInfoMapper mapper) {
        this.participantInfoRepository = participantInfoRepository;
        this.mapper = mapper;
    }

    public List<ParticipantInfoDto> getAll(){
        return mapper.toDtoList(participantInfoRepository.findAll());
    }

    public void save(ParticipantInfoDto dto){

    }

}
