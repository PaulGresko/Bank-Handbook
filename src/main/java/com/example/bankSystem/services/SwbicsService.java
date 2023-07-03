package com.example.bankSystem.services;


import com.example.bankSystem.models.bankModels.Swbics;
import com.example.bankSystem.repositories.SwbicsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;



@Service
public class SwbicsService {

    private final SwbicsRepository swbicsRepository;

    @Autowired
    public SwbicsService(SwbicsRepository swbicsRepository) {
        this.swbicsRepository = swbicsRepository;
    }

    public Swbics getAllSwbicsByBic(Long id){
        return swbicsRepository.findByBicDirectoryEntryId(id);
    }

}
