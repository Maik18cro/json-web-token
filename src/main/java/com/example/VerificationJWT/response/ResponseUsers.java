package com.example.VerificationJWT.response;

import java.util.List;

public class ResponseUsers extends Response {
    private String[] data;


    public ResponseUsers (String[] data, String status, int statusCode, String message){
        super(status,statusCode, message);
        this.data = data;

    }

    public String[] getData () {
        return data;
    }

}
