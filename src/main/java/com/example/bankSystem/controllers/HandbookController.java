package com.example.bankSystem.controllers;


import com.example.bankSystem.dto.HandbookDto;
import com.example.bankSystem.enums.HandbookType;
import com.example.bankSystem.models.Handbook;
import com.example.bankSystem.services.HandbookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/handbook")
public class HandbookController {

    private final HandbookService service;

    @Autowired
    public HandbookController(HandbookService service) {
        this.service = service;
    }

    @GetMapping("/{type}")
    public ResponseEntity<List<Handbook>> getAll(@PathVariable String type, @RequestParam(defaultValue = "1") Integer page){
        return ResponseEntity.ok(service.getAllByType(HandbookType.valueOf(type), page));
    }

    @PostMapping("/save")
    public ResponseEntity<Handbook> save(@RequestBody HandbookDto dto){
        return ResponseEntity.ok(service.save(dto));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Handbook> update(@PathVariable Long id, @RequestBody HandbookDto dto){
        return ResponseEntity.ok(service.update(id, dto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id){
        service.delete(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).body("Handbook was deleted");
    }

    @PatchMapping("/{id}")
    public ResponseEntity<Handbook> recovery(@PathVariable Long id){
        return ResponseEntity.ok(service.recover(id));
    }

    @GetMapping("/{type}/count")
    public Long getCountByType(@PathVariable String type){
        return service.getCountByType(HandbookType.valueOf(type));
    }
}
