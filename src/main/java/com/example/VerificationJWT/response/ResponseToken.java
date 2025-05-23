package com.example.VerificationJWT.response;

import com.example.VerificationJWT.services.User;

public class ResponseToken extends Response {
    private String Token;

    public ResponseToken(String status,int statusCode,String message,String token){
        super(status,statusCode,message);
        this.Token = token;
    }

    public String getToken(){
        return Token;
    }
}
