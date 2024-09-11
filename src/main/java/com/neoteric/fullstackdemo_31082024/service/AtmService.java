package com.neoteric.fullstackdemo_31082024.service;

import com.neoteric.fullstackdemo_31082024.Exception.AccountCreationFailedException;
import com.neoteric.fullstackdemo_31082024.Exception.AtmCreationFailedException;
import com.neoteric.fullstackdemo_31082024.model.Account;
import com.neoteric.fullstackdemo_31082024.model.Atm;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.UUID;

public class AtmService {

    public String createAtm(Atm atm) throws AtmCreationFailedException {
        String cardnumber = null;
        try {
            Connection connection = DBConnection.getConnection();
            Statement stmt = connection.createStatement();
            cardnumber = UUID.randomUUID().toString();
//            String query = "insert into bank.account values( " + "'" +account.getAccountNumber()  + "'" + ","
//                    + account.getMobileNumber()+ "'" + ","
//                    + account.getName()+"'"+"'"
//                    +account.getPan()+"'"+","
//              +account.getBalance() + ")";


            String query = "insert into bank.atm values("+
                    "'"+cardnumber+"'"+","+

                    "'"+atm.getPin()+"'"+","+
                    "'"+atm.getCvv()+"'"+","+
                    "'"+atm.getAccountNumber()+"'"+")";
            int status = stmt.executeUpdate(query);
            if (status==1) {
                System.out.println("Account is creation" + cardnumber);
            } else {
                throw new AtmCreationFailedException("Account creation is failed"+atm.getPin());

            }
        } catch (SQLException e) {
            System.out.println("Exception occured in Sql" + e);

        } catch (AtmCreationFailedException e) {
            System.out.println("exception occured"+e);
            throw e;
        }
        return cardnumber;
    }
}
