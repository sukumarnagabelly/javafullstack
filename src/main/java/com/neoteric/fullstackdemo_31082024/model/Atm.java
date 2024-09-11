package com.neoteric.fullstackdemo_31082024.model;

import lombok.Builder;
import lombok.Data;

import java.util.Date;
@Builder
@Data
public class Atm {
    private String cardnumber;
    private String pin;
    private String accountNumber;
    private String cvv;
   // private Date cardExpiry;
}
