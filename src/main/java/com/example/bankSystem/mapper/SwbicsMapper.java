package com.example.bankSystem.mapper;


import com.example.bankSystem.dto.SwbicsDto;
import com.example.bankSystem.models.bankModels.Swbics;
import jakarta.persistence.Access;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class SwbicsMapper {
    private final ModelMapper modelMapper;

    @Autowired
    public SwbicsMapper(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }

    public SwbicsDto toDto(Swbics swbics){
        return modelMapper.map(swbics, SwbicsDto.class);
    }

    public List<SwbicsDto> toDtoList(List<Swbics> swbicsList){
        return swbicsList.stream().map(this::toDto).collect(Collectors.toList());
    }

    public Swbics toModel(SwbicsDto swbicsDto){
        return modelMapper.map(swbicsDto, Swbics.class);
    }

    public List<Swbics> toModelList(List<SwbicsDto> swbicsDtoList){
        return swbicsDtoList.stream().map(this::toModel).collect(Collectors.toList());
    }
}
