package com.example.VerificationJWT.databases;

import com.example.VerificationJWT.controlers.ControlersRegister;
import com.example.VerificationJWT.services.Users;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class DataBases {
    List<Users> customers = new ArrayList<>();
    public List<Users> databases(Users use) {
    ControlersRegister controlersRegister = new ControlersRegister();
    customers.add(use);
    Users dataUsers = customers.get(0);
    int sizeUsers = customers.size();
    System.out.printf(String.valueOf(sizeUsers));
        return customers;



    }

}
