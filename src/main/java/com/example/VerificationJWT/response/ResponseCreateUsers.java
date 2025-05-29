package com.example.VerificationJWT.response;

public class ResponseCreateUsers extends Response{
    String data;
    public ResponseCreateUsers(String data, String status, int statusCode, String message) {
        super(status, statusCode, message);
        this.data = data;
    }
    public String getData() {
        return data;
    }
}
