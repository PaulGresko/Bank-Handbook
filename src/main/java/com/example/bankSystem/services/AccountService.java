package com.example.bankSystem.services;


import com.example.bankSystem.models.bankModels.Account;
import com.example.bankSystem.repositories.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AccountService {

    private final AccountRepository accountRepository;

    @Autowired
    public AccountService(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }

    public List<Account> getAllAccountsByBIC(Long id){
        return accountRepository.findAllByBicDirectoryEntryId(id);
    }
}
