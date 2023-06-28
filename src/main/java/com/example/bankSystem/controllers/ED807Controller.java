package com.example.bankSystem.controllers;


import com.example.bankSystem.dto.ED807Dto;
import com.example.bankSystem.mapper.ED807Mapper;
import com.example.bankSystem.models.bankModels.ED807;
import com.example.bankSystem.parsingFromXML.ParsingED807FromXML;
import com.example.bankSystem.repositories.ED807Repository;
import jakarta.xml.bind.JAXBException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController
@RequestMapping("/info")
public class ED807Controller {

    private final ED807Repository repository;
    private final ED807Mapper ed807Mapper;

    @Autowired
    public ED807Controller(ED807Repository repository, ED807Mapper ed807Mapper) {
        this.repository = repository;
        this.ed807Mapper = ed807Mapper;
    }

    @GetMapping
    public ED807Dto getInfo() throws JAXBException {
        ED807Dto ed807 = ParsingED807FromXML.parse("C:\\Users\\Paul\\Desktop\\Practic\\20220630_ED807_full.xml");
        repository.save(ed807Mapper.toModel(ed807));
        return ed807;
    }

    @GetMapping("/hello")
    public List<ED807> getHello(){
        List<ED807> ed807List = repository.findAll();
        return  ed807List;
    }

    @GetMapping("/delete")
    public void deleteED807(){
        ED807 ed807 = repository.findById(Long.valueOf(1)).get();
        ed807.setDeleted(true);
        repository.save(ed807);
    }

}
