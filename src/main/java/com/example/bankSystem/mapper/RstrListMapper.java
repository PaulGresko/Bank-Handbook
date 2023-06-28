package com.example.bankSystem.mapper;

import com.example.bankSystem.dto.RstrListDto;
import com.example.bankSystem.models.bankModels.RstrList;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class RstrListMapper {

    private final ModelMapper modelMapper;

    @Autowired
    public RstrListMapper(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }

    public RstrListDto toDto(RstrList rstrList){
        return modelMapper.map(rstrList, RstrListDto.class);
    }
    public List<RstrListDto> toDtoList(List<RstrList> rstrLists){
        return rstrLists.stream().map(this::toDto).collect(Collectors.toList());
    }

    public RstrList toModel(RstrListDto rstrListDto){
        return modelMapper.map(rstrListDto, RstrList.class);
    }

    public List<RstrList> toModelList(List<RstrListDto> rstrListDtos){
        return rstrListDtos.stream().map(this::toModel).collect(Collectors.toList());
    }

}
