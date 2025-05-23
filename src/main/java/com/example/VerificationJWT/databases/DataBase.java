package com.example.VerificationJWT.databases;
import com.example.VerificationJWT.services.User;

import java.util.ArrayList;
import java.util.List;

public class DataBase {
    List<User> customers = new ArrayList<>();
    int allowId = 0;

    public DataBase(String email, String user, String password, String city) {
         this.createNewUser(email, user, password, city);
    }
    public User getUserById(int num){
        return customers.get(num);
    }

    public User getUserByEmail(String email) {
        if (email == null) {
            return null;
        }
        for (User emailCustomer : customers) {
            if (emailCustomer.getEmail().equals(email)) {
                return emailCustomer;
            }
        }
        return null;
    }

    public User getUserByName(String user){
        for (User nameCustomer : customers ){
            if (nameCustomer.getName().equals(user)){
                return nameCustomer;
            }
            break;
        }
        return null;
    }

    public User getUserByPassword(String password){
        for (User passwordCustomer : customers){
            if (passwordCustomer.getPassword().equals(password)){
                return passwordCustomer;
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

        return this.getUserById(id);
    }
    public int getUserSize(){
        return customers.size();
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
