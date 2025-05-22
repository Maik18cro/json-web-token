package com.example.VerificationJWT.databases;
import com.example.VerificationJWT.services.User;

import java.util.ArrayList;
import java.util.List;

public class DataBases {
    List<User> customers = new ArrayList<>();
    int allowId = 0;

    public DataBases(String email, String user, String password, String city) {
        this.createNewUser(email, user, password, city);
    }
    public User getUsersById(int num){
        return customers.get(num);
    }

    public User getUserByEmail(String email) {
        for (User customer : customers) {
            if (customer.getEmail().equals(email)){
                return customer;
            }
            break;
        }

        return null;
    }

    public User createNewUser(String email, String user, String password, String city) {
        int id = allowId;
        User newUser = new User(
                id,
                email,
                user,
                password,
                city
        );

        customers.add(newUser);
        allowId++;

        return this.getUsersById(id);
    }
//    public int getIdUser(int id) {
//        return id;
//    }
//    public String getEmail(String email) {
//        return email;
//    }
//    public String getPassword(int i) {
//        return customers.get(i).getPassword();
//    }
//    public int getId(int i) {
//        return customers.get(i).getId();
//    }

}
