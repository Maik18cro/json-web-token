package com.example.VerificationJWT.response;

import com.example.VerificationJWT.services.User;

public class ResponseUsers extends Response {
    private User data;


    public ResponseUsers (User data, String status, int statusCode, String message){
        super(status,statusCode, message);
        this.data = data;
    }

    public User getData () {
        return data;
    }

}
