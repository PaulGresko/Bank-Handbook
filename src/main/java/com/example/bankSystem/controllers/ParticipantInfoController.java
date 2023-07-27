package com.example.bankSystem.controllers;

import com.example.bankSystem.dto.ParticipantInfoDto;
import com.example.bankSystem.mapper.ParticipantInfoMapper;
import com.example.bankSystem.repositories.ParticipantInfoRepository;
import com.example.bankSystem.services.ParticipantInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("/participantInfo")
public class ParticipantInfoController {

    private final ParticipantInfoService service;


    @Autowired
    public ParticipantInfoController(ParticipantInfoService service) {
        this.service = service;
    }

    @GetMapping("/{ed807}")
    public  List<ParticipantInfoDto> getAll(@RequestParam(defaultValue = "0") String page,
                                            @PathVariable Long ed807,
                                            @RequestParam Optional<String> bic,
                                            @RequestParam(defaultValue = "") String name,
                                            @RequestParam Optional<String> ptType){
        return service.getAllByCategories(Integer.parseInt(page), ed807, bic.orElse(null), name, ptType.orElse(null));
    }

    @GetMapping("/{ed807}/count")
    public Long getCount(@PathVariable Long ed807,
                                      @RequestParam Optional<String> bic,
                                      @RequestParam(defaultValue = "") String name,
                                      @RequestParam Optional<String> ptType){
        return service.getCount(ed807,bic.orElse(null),name,ptType.orElse(null));
    }


}
