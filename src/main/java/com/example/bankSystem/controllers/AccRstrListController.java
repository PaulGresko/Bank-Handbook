package com.example.bankSystem.controllers;


import com.example.bankSystem.models.bankModels.AccRstrList;
import com.example.bankSystem.services.AccRstrListService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/accRstr")
public class AccRstrListController {


    private final AccRstrListService service;

    @Autowired
    public AccRstrListController(AccRstrListService service) {
        this.service = service;
    }

    @GetMapping("/{account}")
    public List<AccRstrList> getByAccount(@PathVariable Long account){
        return service.getByAccount(account);
    }
}
