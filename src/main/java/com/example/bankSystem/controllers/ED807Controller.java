package com.example.bankSystem.controllers;



import com.example.bankSystem.dto.parseXml.ED807Xml;
import com.example.bankSystem.models.bankModels.ED807;
import com.example.bankSystem.services.ED807Service;
import jakarta.xml.bind.JAXBException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;


@RestController
@RequestMapping("/ed807")
public class ED807Controller {

    private final ED807Service ed807Service;

    @Autowired
    public ED807Controller(ED807Service ed807Service) {
        this.ed807Service = ed807Service;
    }


    @GetMapping("/save")
    public ED807Xml getInfo() throws JAXBException {
        return ed807Service.parse("C:\\Users\\Paul\\Desktop\\Practic\\20220630_ED807_full.xml");
    }

    @GetMapping
    public List<ED807> getAll(@RequestParam(defaultValue = "1") Integer page){
        return  ed807Service.getAll(page);
    }

    @GetMapping("/delete/{id}")
    public void deleteED807(@PathVariable Long id){
        ed807Service.delete(id);
    }

    @GetMapping("/recover/{id}")
    public void recoverED807(@PathVariable Long id){
        ed807Service.recover(id);
    }


    @GetMapping("/count")
    public Map<String, Long> getCount(){
        return Map.of("count", ed807Service.getCount());
    }

}
