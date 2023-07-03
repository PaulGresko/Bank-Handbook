package com.example.bankSystem.services;

import com.example.bankSystem.dto.HandbookDto;
import com.example.bankSystem.enums.HandbookType;
import com.example.bankSystem.mapper.HandbookMapper;
import com.example.bankSystem.models.Handbook;
import com.example.bankSystem.repositories.HandbookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.NoSuchElementException;

@Service
public class HandbookService {

    private final HandbookRepository handbookRepository;
    private final HandbookMapper handbookMapper;


    @Autowired
    public HandbookService(HandbookRepository handbookRepository, HandbookMapper handbookMapper) {
        this.handbookRepository = handbookRepository;
        this.handbookMapper = handbookMapper;
    }


    public List<Handbook> getAllByType(HandbookType type, int page){
        return handbookRepository.findAllByTypeAndDeleted(type, PageRequest.of(page,20), false).getContent();
    }

    @Transactional
    public Handbook save(HandbookDto handbookDto){
       return handbookRepository.save(handbookMapper.toModel(handbookDto));
    }

    @Transactional
    public Handbook update(Long id, HandbookDto handbookDto){
        Handbook handbook = handbookRepository.findById(id).orElseThrow(()->new NoSuchElementException("Handbook not found"));
        if(handbook.getDeleted()){
                throw new NoSuchElementException("Handbook was deleted");
        }
        handbook.setCode(handbookDto.getCode());
        handbook.setName(handbookDto.getName());
        handbook.setValidFrom(handbookDto.getValidFrom());
        handbook.setValidUntil(handbookDto.getValidUntil());
        return handbookRepository.save(handbook);
    }

    @Transactional
    public void delete(Long id){
        Handbook handbook = handbookRepository.findById(id).orElseThrow(()->new NoSuchElementException("Handbook not found"));
        handbook.setDeleted(true);
        handbookRepository.save(handbook);
    }

    @Transactional
    public Handbook recover(Long id){
        Handbook handbook = handbookRepository.findById(id).orElseThrow(()->new NoSuchElementException("Handbook not found"));
        handbook.setDeleted(false);
        return handbookRepository.save(handbook);
    }

    public Long getCountByType(HandbookType type){
        return handbookRepository.countByType(type);
    }
}
