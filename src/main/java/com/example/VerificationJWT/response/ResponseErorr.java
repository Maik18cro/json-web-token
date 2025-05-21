package com.example.VerificationJWT.response;

public class ResponseErorr extends Response{
    private String error;

    public ResponseErorr(String status,int statusCode,String message,String error) {
    super(status,statusCode,message);
    this.error = error;
    }

    public String getError() {
        return error;
    }
}
