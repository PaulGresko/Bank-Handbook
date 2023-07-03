package com.example.bankSystem.services;



import com.example.bankSystem.models.bankModels.RstrList;
import com.example.bankSystem.repositories.RstrListRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class RstrListService {

    private final RstrListRepository rstrListRepository;

    @Autowired
    public RstrListService(RstrListRepository rstrListRepository) {
        this.rstrListRepository = rstrListRepository;
    }

    public RstrList getByPartInfo(Long id){
        return rstrListRepository.findByParticipantInfoId(id);
    }
}
