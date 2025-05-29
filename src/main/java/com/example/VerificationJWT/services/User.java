package com.example.VerificationJWT.services;

public class User {
    private String id;
    private String email;
    private String name;
    private String password;
    private String city;


    public User(String id, String email, String name, String password, String city){
        this.id = id;
        this.email= email;
        this.name = name;
        this.password = password;
        this.city = city;
    }
    public String getId(){
        return id;
    }
    public String getEmail(){
        return email;
    }
    public String getName(){
        return name;
    }
    public String getPassword(){
        return password;
    }
    public String getCity(){
        return city;
    }


}
