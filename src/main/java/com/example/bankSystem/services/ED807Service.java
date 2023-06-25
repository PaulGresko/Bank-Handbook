package com.example.bankSystem.services;


import com.example.bankSystem.models.bankModels.ED807;
import com.example.bankSystem.repositories.ED807Repository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;

@Service
public class ED807Service {

    private final ED807Repository ed807Repository;

    public ED807Service(ED807Repository ed807Repository) {
        this.ed807Repository = ed807Repository;
    }

    public List<ED807> getAll(){
        return ed807Repository.findAll();
    }
    public ED807 getOne(Long id){
        return ed807Repository.findById(id).orElseThrow(()-> new NoSuchElementException("ED807 not found"));
    }
    public ED807 save(ED807 ed807){
        return ed807Repository.save(ed807);
    }

    public ED807 update(Long id, ED807 ed807){
        ed807.setId(id);
        return ed807Repository.save(ed807);
    }

    public void delete(Long id){
        ed807Repository.deleteById(id);
    }

}
