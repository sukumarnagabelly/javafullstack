package com.neoteric.fullstackdemo_31082024.service;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBConnection {
    public static Connection connection;

    public  static Connection getConnection() {
        try {
            if (connection == null) {
                System.out.println(" Getting Connection");
                Class.forName("com.mysql.cj.jdbc.Driver");
                connection = DriverManager.getConnection("jdbc:mysql://@localhost:3306/bank", "root", "1998");


            } else {
                System.out.println(" Returning existing connection");
            }
        } catch (Exception e) {
            System.out.println("Exception occcured in getconnection"+e);
        }
        return connection;
    }

    }



