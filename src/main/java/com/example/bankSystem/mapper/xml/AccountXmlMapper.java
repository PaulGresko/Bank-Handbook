package com.example.bankSystem.mapper.xml;

import com.example.bankSystem.dto.xml.AccountXml;
import com.example.bankSystem.models.bankModels.Account;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class AccountXmlMapper {

    private final ModelMapper modelMapper;
    private final AccRstrListXmlMapper accRstrListXmlMapper;

    @Autowired
    public AccountXmlMapper(ModelMapper modelMapper, AccRstrListXmlMapper accRstrListXmlMapper) {
        this.modelMapper = modelMapper;
        this.accRstrListXmlMapper = accRstrListXmlMapper;
    }

    public AccountXml toDto(Account account) {

        AccountXml accountXml = modelMapper.map(account, AccountXml.class);
        accountXml.setAccRstrLists(accRstrListXmlMapper.toDtoList(account.getAccRstrLists()));

        return accountXml;
    }
    public List<AccountXml> toDtoList(List<Account> accountList){
        return accountList.stream().map(this::toDto).collect(Collectors.toList());
    }

    public Account toModel(AccountXml accountXml) {

        Account account = modelMapper.map(accountXml,Account.class);
        account.setAccRstrLists(accRstrListXmlMapper.toModelList(accountXml.getAccRstrLists()));
        return account;
    }
    public List<Account> toModelList(List<AccountXml> accountXmlList){
        return accountXmlList.stream().map(this::toModel).collect(Collectors.toList());
    }

}
