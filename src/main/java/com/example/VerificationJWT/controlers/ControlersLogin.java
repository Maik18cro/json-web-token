package com.example.VerificationJWT.controlers;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ControlersLogin {
    @PostMapping("/login")
    @ResponseBody
    public String login(@RequestParam String email,@RequestParam String password){
        return "";

    }
}
