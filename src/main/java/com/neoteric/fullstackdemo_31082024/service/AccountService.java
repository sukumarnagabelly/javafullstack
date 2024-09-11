package com.neoteric.fullstackdemo_31082024.service;

import com.neoteric.fullstackdemo_31082024.Exception.AccountCreationFailedException;
import com.neoteric.fullstackdemo_31082024.hibernate.HibernateUtils;
import com.neoteric.fullstackdemo_31082024.model.Account;
import com.neoteric.fullstackdemo_31082024.model.AccountEntity;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.UUID;

public class AccountService {


    public String createAccountUsingHibernate(Account account){

        SessionFactory sessionFactory= HibernateUtils.getSessionFactory();
        Session session=sessionFactory.openSession();

        Transaction transaction= session.beginTransaction();

        AccountEntity accountEntity= new AccountEntity();
        accountEntity.setAccountNumber(UUID.randomUUID().toString());
        accountEntity.setName(account.getName());
        accountEntity.setPan(account.getPan());
        accountEntity.setMobileNumber(account.getMobileNumber());
        accountEntity.setBalance(account.getBalance());

        session.persist(accountEntity);

        transaction.commit();

        return accountEntity.getAccountNumber();
    }




    public String createAccount(Account account) throws AccountCreationFailedException {
        String accountNumber = null;
        try {
            Connection connection = DBConnection.getConnection();
            Statement stmt = connection.createStatement();
            accountNumber = UUID.randomUUID().toString();
//            String query = "insert into bank.account values( " + "'" +account.getAccountNumber()  + "'" + ","
//                    + account.getMobileNumber()+ "'" + ","
//                    + account.getName()+"'"+"'"
//                    +account.getPan()+"'"+","
//              +account.getBalance() + ")";


            String query = "insert into bank.account values('"+
                    accountNumber+"'"+","+

                    "'"+account.getName()+"'"+","+
                    "'"+account.getPan()+"'"+","+
                    "'"+account.getMobileNumber()+"'"+","
                    + account.getBalance()+")";
            int status = stmt.executeUpdate(query);
            if (status==1) {
                System.out.println("Account is creation" + accountNumber);
            } else {
                throw new AccountCreationFailedException("Account creation is failed"+account.getPan());

            }
        } catch (SQLException e) {
            System.out.println("Exception occured in Sql" + e);

        } catch (AccountCreationFailedException e) {
            System.out.println("exception occured"+e);
            throw e;
        }
        return accountNumber;
    }
    }


