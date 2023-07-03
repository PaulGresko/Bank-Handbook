package com.example.bankSystem.mapper;

import com.example.bankSystem.dto.HandbookDto;
import com.example.bankSystem.models.Handbook;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class HandbookMapper {

    private final ModelMapper modelMapper;

    @Autowired
    public HandbookMapper(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }

    public HandbookDto toDto(Handbook handbook){
        return modelMapper.map(handbook,HandbookDto.class);
    }
    public List<HandbookDto> toDtoList(List<Handbook> handbookList){
        return handbookList.stream().map(this::toDto).collect(Collectors.toList());
    }

    public Handbook toModel(HandbookDto handbookDto){
        return modelMapper.map(handbookDto,Handbook.class);
    }

    public List<Handbook> toModelList(List<HandbookDto> handbookDtoList){
        return handbookDtoList.stream().map(this::toModel).collect(Collectors.toList());
    }
}
