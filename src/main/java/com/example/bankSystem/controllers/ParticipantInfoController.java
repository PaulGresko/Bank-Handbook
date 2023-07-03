package com.example.bankSystem.controllers;

import com.example.bankSystem.dto.ParticipantInfoDto;
import com.example.bankSystem.mapper.ParticipantInfoMapper;
import com.example.bankSystem.models.bankModels.ParticipantInfo;
import com.example.bankSystem.repositories.ParticipantInfoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.NoSuchElementException;

@RestController
@RequestMapping("/participantInfo")
public class ParticipantInfoController {

    private final ParticipantInfoRepository repository;
    private final ParticipantInfoMapper mapper;


    @Autowired
    public ParticipantInfoController(ParticipantInfoRepository repository, ParticipantInfoMapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    @GetMapping("/update")
    public ResponseEntity<ParticipantInfoDto> setEnglName() {
        ParticipantInfo participantInfo = repository.findById(1L).orElseThrow(()-> new NoSuchElementException("participantInfo not found"));
        participantInfo.setEnglName(participantInfo.getNameP());

    return ResponseEntity.ok(mapper.toDto(repository.save(participantInfo)));
    }

}
