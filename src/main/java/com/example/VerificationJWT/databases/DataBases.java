package com.example.VerificationJWT.databases;

import com.example.VerificationJWT.controlers.ControlersRegister;
import com.example.VerificationJWT.services.Users;

import java.util.ArrayList;
import java.util.List;

public class DataBases {
    List<Users> customers = new ArrayList<>();
    public List<Users> databases(int id, String email, String user, String password, String city) {
        Users use = new Users(
                id,
                email,
                user,
                password,
                city
        );
    ControlersRegister controlersRegister = new ControlersRegister();
    customers.add(use);
    int sizeUsers = customers.size();
    System.out.printf(String.valueOf(sizeUsers));
        return customers;
    }
    public Users getUsers(int num){
        return customers.get(num);
    }
    public int getSizeList() {
        return customers.size();
    }
    public int getIdUser(int id) {
        return id;
    }

}
