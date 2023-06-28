package com.example.bankSystem.mapper;

import com.example.bankSystem.dto.AccountDto;
import com.example.bankSystem.models.bankModels.Account;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class AccountMapper {

    private final ModelMapper modelMapper;
    private final AccRstrListMapper accRstrListMapper;

    @Autowired
    public AccountMapper(ModelMapper modelMapper, AccRstrListMapper accRstrListMapper) {
        this.modelMapper = modelMapper;
        this.accRstrListMapper = accRstrListMapper;
    }

    public AccountDto toDto(Account account) {

        AccountDto accountDto = modelMapper.map(account, AccountDto.class);
        accountDto.setAccRstrLists(accRstrListMapper.toDtoList(account.getAccRstrLists()));

        return accountDto;
    }
    public List<AccountDto> toDtoList(List<Account> accountList){
        return accountList.stream().map(this::toDto).collect(Collectors.toList());
    }

    public Account toModel(AccountDto accountDto) {

        Account account = modelMapper.map(accountDto,Account.class);
        account.setAccRstrLists(accRstrListMapper.toModelList(accountDto.getAccRstrLists()));
        return account;
    }
    public List<Account> toModelList(List<AccountDto> accountDtoList){
        return accountDtoList.stream().map(this::toModel).collect(Collectors.toList());
    }

}
