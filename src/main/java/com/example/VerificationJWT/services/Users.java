package com.example.VerificationJWT.services;

public class Users {
    private int id;
    private String email;
    private String name;
    private String password;
    private String city;


    public Users(int id,String email, String name, String password,String city){
        this.id = id;
        this.email= email;
        this.name = name;
        this.password = password;
        this.city = city;
    }
    public int getId(){
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
