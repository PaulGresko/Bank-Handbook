package com.example.bankSystem.controllers;


import com.example.bankSystem.models.*;
import com.example.bankSystem.parsingFromXML.ParsingED807FromXML;
import com.example.bankSystem.repositories.BICDirectoryEntryRepository;
import com.example.bankSystem.repositories.ED807Repository;
import jakarta.xml.bind.JAXBException;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController
@RequestMapping("/info")
public class ED807Controller {

    private final ED807Repository repository;
    private final BICDirectoryEntryRepository bicDirectoryEntryRepository;

    public ED807Controller(ED807Repository repository, BICDirectoryEntryRepository bicDirectoryEntryRepository) {
        this.repository = repository;
        this.bicDirectoryEntryRepository = bicDirectoryEntryRepository;
    }

    @GetMapping
    public ED807 getInfo() throws JAXBException {
        ED807 ed807 = ParsingED807FromXML.parse("C:\\Users\\Paul\\Desktop\\Practic\\20220630_ED807_full.xml");
        repository.save(ed807);
        return ed807;
    }


}
