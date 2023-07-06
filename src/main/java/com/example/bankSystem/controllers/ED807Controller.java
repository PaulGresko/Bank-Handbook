package com.example.bankSystem.controllers;



import com.example.bankSystem.dto.ED807Dto;
import com.example.bankSystem.models.bankModels.ED807;
import com.example.bankSystem.services.ED807Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.time.LocalDate;
import java.util.*;


@RestController
@RequestMapping("/ed807")
public class ED807Controller {

    private final ED807Service ed807Service;

    @Autowired
    public ED807Controller(ED807Service ed807Service) {
        this.ed807Service = ed807Service;
    }


    @PostMapping("/actualize")
    public ED807 actualize(@RequestParam Optional<String> title){
        return ed807Service.actualize(title);
    }

    @PostMapping("/save")
    public ED807 parseFromFile(@RequestPart MultipartFile file,
                               @RequestParam Optional<String> title) throws IOException {
        return ed807Service.parse(file, title);
    }

    @GetMapping
    public List<ED807Dto> getAll(@RequestParam(defaultValue = "0") String page,
                                 @RequestParam(defaultValue = "") String title,
                                 @RequestParam(defaultValue = "false") Boolean deleted,
                                 @RequestParam(required = false) Optional<LocalDate> date1,
                                 @RequestParam(required = false) Optional<LocalDate> date2 ){
        return ed807Service.getByCategories(Integer.valueOf(page), title, deleted, date1, date2);
    }

    @PutMapping("/{id}")
    public ED807Dto update(@PathVariable Long id, @RequestBody ED807Dto ed807){
        return ed807Service.update(id, ed807);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteED807(@PathVariable Long id){
        ed807Service.delete(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).body("ED807 was deleted");
    }

    @PatchMapping("/{id}")
    public ED807Dto recoverED807(@PathVariable Long id){
       return ed807Service.recover(id);
    }



    @GetMapping("/count")
    public Map<String, Long> getCount(@RequestParam(defaultValue = "") String title,
                                      @RequestParam(defaultValue = "false") Boolean deleted,
                                      @RequestParam(required = false) Optional<LocalDate> date1,
                                      @RequestParam(required = false) Optional<LocalDate> date2 ){
        return Map.of("count", ed807Service.getCount(title, deleted, date1, date2));
    }
}
