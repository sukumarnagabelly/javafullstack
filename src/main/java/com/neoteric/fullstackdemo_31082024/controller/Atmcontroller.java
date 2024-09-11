package com.neoteric.fullstackdemo_31082024.controller;

import com.neoteric.fullstackdemo_31082024.Exception.AccountCreationFailedException;
import com.neoteric.fullstackdemo_31082024.Exception.AtmCreationFailedException;
import com.neoteric.fullstackdemo_31082024.model.Account;
import com.neoteric.fullstackdemo_31082024.model.Atm;
import com.neoteric.fullstackdemo_31082024.service.AccountService;
import com.neoteric.fullstackdemo_31082024.service.AtmService;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin("*")
@RestController
public class Atmcontroller {
    @PostMapping(value ="/api/createAtm",
            consumes = "application/json",
            produces="application/json")
    public Atm getCardNumber(@RequestBody Atm atm)throws AtmCreationFailedException {
        AtmService atmService=new AtmService();
        String  cardnumber=atmService.createAtm(atm);
        atm.setCardnumber(cardnumber);
        return atm;
    }

}
