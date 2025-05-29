package com.example.VerificationJWT.response;

import com.example.VerificationJWT.services.User;

public class ResponseUsers extends Response {
    private String id;
    private String email;
    private String name;
    private String password;
    private String city;


    public ResponseUsers(String id, String email, String name, String password, String city, String status, int statusCode, String message) {
        super(status, statusCode, message);
        this.id = id;
        this.email = email;
        this.name = name;
        this.password = password;
        this.city = city;
    }

    public String getId() {
        return id;
    }

    public String getEmail() {
        return email;
    }

    public String getName() {
        return name;
    }

    public String getPassword() {
        return password;
    }

    public String getCity() {
        return city;
    }
}

