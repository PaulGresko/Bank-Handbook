package com.example.bankSystem.controllers;


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

    @Autowired
    public ED807Controller(ED807Repository repository) {
        this.repository = repository;
    }

    @GetMapping
    public ED807 getInfo() throws JAXBException {
        ED807 ed807 = ParsingED807FromXML.parse("C:\\Users\\Paul\\Desktop\\Practic\\20220630_ED807_full.xml");
        repository.save(ed807);
        return ed807;
    }

    @GetMapping("/hello")
    public List<ED807> getHello(){
        return repository.findAll();
    }
}
