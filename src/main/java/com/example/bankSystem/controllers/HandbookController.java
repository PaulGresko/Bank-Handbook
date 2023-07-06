package com.example.bankSystem.controllers;


import com.example.bankSystem.dto.HandbookDto;
import com.example.bankSystem.enums.handbook.HandbookType;
import com.example.bankSystem.models.Handbook;
import com.example.bankSystem.services.HandbookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("/handbook")
public class HandbookController {

    private final HandbookService service;

    @Autowired
    public HandbookController(HandbookService service) {
        this.service = service;
    }


    @GetMapping
    public void get(){
        service.insert100Handbooks();
    }
    @GetMapping("/{type}")
    public List<Handbook> getAll(@PathVariable HandbookType type,
                                                 @RequestParam(defaultValue = "0") Integer page,
                                                 @RequestParam(defaultValue = "false") Boolean deleted,
                                                 @RequestParam(defaultValue = "") String code,
                                                 @RequestParam(defaultValue = "") String title,
                                                 @RequestParam(required = false) Optional<LocalDate> date){
        return service.getAllByCategory(page, type, deleted, code, title, date.orElse(null));
    }

    @PostMapping("/save")
    public Handbook save(@RequestBody HandbookDto dto){
        return service.save(dto);
    }

    @PutMapping("/{id}")
    public Handbook update(@PathVariable Long id, @RequestBody HandbookDto dto){
        return service.update(id, dto);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id){
        service.delete(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).body("Handbook was deleted");
    }

    @PatchMapping("/{id}")
    public Handbook recovery(@PathVariable Long id){
        return service.recover(id);
    }

    @GetMapping("/{type}/count")
    public Map<String, Long> getCountByType(@PathVariable HandbookType type,
                              @RequestParam(defaultValue = "false") Boolean deleted,
                              @RequestParam(defaultValue = "") String code,
                              @RequestParam(defaultValue = "") String title,
                              @RequestParam(required = false) Optional<LocalDate> date){
        return Map.of("count", service.getCountByType(type, deleted, code, title, date.orElse(null)));
    }
}
