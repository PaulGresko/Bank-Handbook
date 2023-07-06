package com.example.bankSystem.services;



import com.example.bankSystem.models.bankModels.AccRstrList;
import com.example.bankSystem.repositories.AccRstrListRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class AccRstrListService {

    private final AccRstrListRepository accRstrListRepository;

    @Autowired
    public AccRstrListService(AccRstrListRepository accRstrListRepository) {
        this.accRstrListRepository = accRstrListRepository;
    }

    public List<AccRstrList> getByAccount(Long account) {
        return accRstrListRepository.findAllByAccountId(account);
    }
}
