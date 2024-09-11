package com.neoteric.fullstackdemo_31082024.controller;

import com.neoteric.fullstackdemo_31082024.Exception.AccountCreationFailedException;
import com.neoteric.fullstackdemo_31082024.model.Account;
import com.neoteric.fullstackdemo_31082024.service.AccountService;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
@CrossOrigin("*")

@RestController

public class AccountController {
    @PostMapping(value ="/api/createAccount",consumes = "application/json",produces="application/json")
    public  Account getAccountNumber(@RequestBody Account account)throws AccountCreationFailedException {
        AccountService accountService=new AccountService();
        String  accountNumber=accountService.createAccount(account);
        account.setAccountNumber(accountNumber);
       return account;
    }
    @PostMapping(value = "api/createAccountUsingHibernate",consumes = "application/json",produces = "application/json")
    public Account  getAccountNumberUsingHibernate(@RequestBody Account account) throws AccountCreationFailedException {
        AccountService accountService= new AccountService();

        String accNO=accountService.createAccountUsingHibernate(account);
        account.setAccountNumber(accNO);
        return account;

    }

}
