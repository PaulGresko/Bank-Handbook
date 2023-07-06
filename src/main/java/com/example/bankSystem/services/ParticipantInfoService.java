package com.example.bankSystem.services;

import com.example.bankSystem.dto.ParticipantInfoDto;
import com.example.bankSystem.mapper.ParticipantInfoMapper;
import com.example.bankSystem.repositories.ParticipantInfoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
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


    public List<ParticipantInfoDto> getAllByCategories(Integer page, Long ed807, String bic, String name, String ptType){
        return mapper.toDtoList(participantInfoRepository.getByCategories(PageRequest.of(page,100), ed807, bic,name,ptType).getContent());
    }

    public Long getCount(Long ed807, String bic, String name, String ptType){
        return participantInfoRepository.getCountByCategories(ed807, bic, name, ptType);
    }

}
