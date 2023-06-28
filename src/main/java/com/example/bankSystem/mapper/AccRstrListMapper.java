package com.example.bankSystem.mapper;


import com.example.bankSystem.dto.AccRstrListDto;
import com.example.bankSystem.models.bankModels.AccRstrList;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class AccRstrListMapper {

    private final ModelMapper modelMapper;

    @Autowired
    public AccRstrListMapper(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }

    public AccRstrListDto toDto(AccRstrList accRstrList){
        return modelMapper.map(accRstrList, AccRstrListDto.class);
    }
    public List<AccRstrListDto> toDtoList(List<AccRstrList> accRstrLists){
        return accRstrLists.stream().map(this::toDto).collect(Collectors.toList());
    }

    public AccRstrList toModel(AccRstrListDto accRstrListDto) {
        return modelMapper.map(accRstrListDto, AccRstrList.class);
    }
    public List<AccRstrList> toModelList(List<AccRstrListDto> accRstrListDtos){
        return accRstrListDtos.stream().map(this::toModel).collect(Collectors.toList());
    }
}
