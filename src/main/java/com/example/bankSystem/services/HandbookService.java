package com.example.bankSystem.services;

import com.example.bankSystem.dto.HandbookDto;
import com.example.bankSystem.enums.handbook.HandbookType;
import com.example.bankSystem.mapper.HandbookMapper;
import com.example.bankSystem.models.Handbook;
import com.example.bankSystem.repositories.HandbookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
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


    public List<Handbook> getAllByCategory(int page, HandbookType type, Boolean deleted, String code, String title, LocalDate date) {
        return handbookRepository.findByCategory(PageRequest.of(page,20),type.name(), deleted, code, title, date).getContent();
    }

    @Transactional
    public Handbook save(HandbookDto handbookDto) {
        return handbookRepository.save(handbookMapper.toModel(handbookDto));
    }

    @Transactional
    public Handbook update(Long id, HandbookDto handbookDto) {
        Handbook handbook = handbookRepository.findById(id).orElseThrow(() -> new NoSuchElementException("Handbook not found"));
        if (handbook.getDeleted()) {
            throw new NoSuchElementException("Handbook was deleted");
        }
        handbook.setCode(handbookDto.getCode());
        handbook.setTitle(handbookDto.getTitle());
        handbook.setValidFrom(handbookDto.getValidFrom());
        handbook.setValidUntil(handbookDto.getValidUntil());
        return handbookRepository.save(handbook);
    }

    @Transactional
    public void delete(Long id) {
        Handbook handbook = handbookRepository.findById(id).orElseThrow(() -> new NoSuchElementException("Handbook not found"));
        handbook.setDeleted(true);
        handbookRepository.save(handbook);
    }

    @Transactional
    public Handbook recover(Long id) {
        Handbook handbook = handbookRepository.findById(id).orElseThrow(() -> new NoSuchElementException("Handbook not found"));
        handbook.setDeleted(false);
        return handbookRepository.save(handbook);
    }

    public Long getCountByType(HandbookType type, Boolean deleted, String code, String title, LocalDate date) {
        return handbookRepository.getCountByCategory(type.name(), deleted, code, title, date);
    }

    public void insert100Handbooks() {
        List<Handbook> handbooks = new ArrayList<>();

        for (int i = 0; i < 100; i++) {
            Handbook handbook = new Handbook();
            handbook.setType(HandbookType.RstrType);
            handbook.setCode("Code" + i);
            handbook.setTitle("Title" + i);
            handbook.setValidFrom(new Date());
            handbook.setValidUntil(new Date());

            handbooks.add(handbook);
        }

        handbookRepository.saveAll(handbooks);
    }
}
