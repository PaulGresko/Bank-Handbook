package com.example.bankSystem.services;



import com.example.bankSystem.models.bankModels.RstrList;
import com.example.bankSystem.repositories.RstrListRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class RstrListService {

    private final RstrListRepository rstrListRepository;

    @Autowired
    public RstrListService(RstrListRepository rstrListRepository) {
        this.rstrListRepository = rstrListRepository;
    }

    public List<RstrList> getByPartInfo(Long bic){
        return rstrListRepository.findAllByParticipantInfoId(bic);
    }
}
