package com.example.bankSystem.controllers;


import com.example.bankSystem.models.bankModels.RstrList;
import com.example.bankSystem.services.RstrListService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/rstr")
public class RstrListController {

    private final RstrListService service;

    @Autowired
    public RstrListController(RstrListService service) {
        this.service = service;
    }

    @GetMapping("/{bic}")
    public List<RstrList> getByPartInfo(@PathVariable Long bic){
        return service.getByPartInfo(bic);
    }
}
