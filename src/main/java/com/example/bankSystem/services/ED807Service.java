package com.example.bankSystem.services;



import com.example.bankSystem.dto.ED807Dto;
import com.example.bankSystem.mapper.ED807Mapper;
import com.example.bankSystem.models.bankModels.*;
import com.example.bankSystem.parser.Parser;
import com.example.bankSystem.repositories.ED807Repository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.time.LocalDate;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@Service
public class ED807Service {


    private final ED807Repository ed807Repository;
    private final ED807Mapper ed807Mapper;
    private final Parser parser;


    @Autowired
    public ED807Service(ED807Repository ed807Repository, ED807Mapper ed807Mapper, Parser parser) {
        this.ed807Repository = ed807Repository;
        this.ed807Mapper = ed807Mapper;
        this.parser = parser;
    }


    @Transactional
    public ED807Dto actualize(Optional<String> title){
       return ed807Mapper.toDto(ed807Repository.save(parser.actualization(title)));
    }


    @Transactional
    public ED807Dto parse(MultipartFile file, Optional<String> title) throws  IOException {
        ED807 ed807 = parser.parse(file, title);
        ed807Repository.save(ed807);
        return ed807Mapper.toDto(ed807);
    }





    @Transactional
    public ED807Dto update(Long id, ED807Dto dto){
        ED807 ed807 = ed807Repository.findById(id).orElseThrow(()-> new NoSuchElementException("ED807 not found"));
        if(dto.getTitle()            != null) ed807.setTitle(dto.getTitle());
        if(dto.getFileName()         != null) ed807.setFileName(dto.getFileName());
        if(dto.getEdDate()           != null) ed807.setEdDate(dto.getEdDate());
        if(dto.getEdAuthor()         != null) ed807.setEdAuthor(dto.getEdAuthor());
        if(dto.getEdReceiver()       != null) ed807.setEdReceiver(dto.getEdReceiver());
        if(dto.getCreationReason()   != null) ed807.setCreationReason(dto.getCreationReason());
        if(dto.getCreationDateTime() != null) ed807.setCreationDateTime(dto.getCreationDateTime());
        if(dto.getInfoTypeCode()     != null) ed807.setInfoTypeCode(dto.getInfoTypeCode());
        if(dto.getBusinessDay()      != null) ed807.setBusinessDay(dto.getBusinessDay());
        if(dto.getDirectoryVersion() != 0   ) ed807.setDirectoryVersion(dto.getDirectoryVersion());

        return ed807Mapper.toDto(ed807Repository.save(ed807));
    }

    @Transactional
    public void delete(Long id){
        ED807 ed807 = ed807Repository.findById(id).orElseThrow(()-> new NoSuchElementException("ED807 not found"));
        ed807.setDeleted(true);
        ed807Repository.save(ed807);
    }

    @Transactional
    public ED807Dto recover(Long id){
        ED807 ed807 = ed807Repository.findById(id).orElseThrow(()-> new NoSuchElementException("ED807 not found"));
        ed807.setDeleted(false);
        return ed807Mapper.toDto(ed807Repository.save(ed807));
    }

    public Long getCount(String title,  Boolean deleted, Optional<LocalDate> date1, Optional<LocalDate> date2){
       return ed807Repository.getCountByCategory(title, deleted, date1.orElse(null), date2.orElse(null));
    }


    public List<ED807Dto> getByCategories(Integer page, String title, Boolean deleted, Optional<LocalDate> date1, Optional<LocalDate> date2){
        return ed807Mapper.toDtoList(ed807Repository.findByCategory(
                PageRequest.of(page, 5),
                title,
                deleted,
                date1.orElse(null),
                date2.orElse(null))
                .getContent());
    }
}
