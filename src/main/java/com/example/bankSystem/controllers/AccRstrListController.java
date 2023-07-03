package com.example.bankSystem.controllers;


import com.example.bankSystem.models.bankModels.AccRstrList;
import com.example.bankSystem.services.AccRstrListService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/accRstr")
public class AccRstrListController {


    private final AccRstrListService service;

    @Autowired
    public AccRstrListController(AccRstrListService service) {
        this.service = service;
    }

    @GetMapping
    public List<AccRstrList> getByAccount(@RequestParam Long account){
        return service.getByAccount(account);
    }
}
