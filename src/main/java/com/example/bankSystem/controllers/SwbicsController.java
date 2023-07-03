package com.example.bankSystem.controllers;


import com.example.bankSystem.models.bankModels.Swbics;
import com.example.bankSystem.services.SwbicsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/swbics")
public class SwbicsController {

    private final SwbicsService service;

    @Autowired
    public SwbicsController(SwbicsService service) {
        this.service = service;
    }

    @GetMapping
    public Swbics getByBic(@RequestParam Long bic){
        return service.getAllSwbicsByBic(bic);
    }
}
