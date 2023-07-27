package com.example.bankSystem.controllers;

import com.example.bankSystem.models.bankModels.Account;
import com.example.bankSystem.services.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/account")
public class AccountController {

    private final AccountService accountService;

    @Autowired
    public AccountController(AccountService accountService) {
        this.accountService = accountService;
    }

    @GetMapping("/{bic}")
    public List<Account> getAllByBIC(@PathVariable Long bic){
        return accountService.getAllAccountsByBIC(bic);
    }
}
