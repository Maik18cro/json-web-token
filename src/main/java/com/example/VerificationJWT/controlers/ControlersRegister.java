package com.example.VerificationJWT.controlers;

import com.example.VerificationJWT.databases.DataBases;
import com.example.VerificationJWT.response.Response;
import com.example.VerificationJWT.services.Users;
import org.springframework.web.bind.annotation.*;

@RestController
public class ControlersRegister {
    DataBases dataBases = new DataBases();
    @PostMapping("/")
    @ResponseBody
    public Object Register(@RequestParam String email , @RequestParam String user, @RequestParam String password) {
        if (email != null && user != null && password != null) {
            Users use = new Users(
                    email,
                    user,
                    password
            );
            return dataBases.databases(use);
        } else {
            return new Response(
                    "failure",
                    404,
                    "Not Found"
            );
        }
    }
        @PostMapping("/user")
        @ResponseBody
    public Object verificationUser(Users use, @RequestParam int num) {
            if (num < dataBases.databases(use).size()) {
                return dataBases.databases(use).get(num);
            } else {
                return new Response(
                        "failure",
                        404,
                        "Not Found"
                );
            }
        }
}
