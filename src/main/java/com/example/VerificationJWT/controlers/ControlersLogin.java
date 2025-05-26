package com.example.VerificationJWT.controlers;

import com.example.VerificationJWT.databases.DataBase;
import com.example.VerificationJWT.services.User;
import org.springframework.web.bind.annotation.*;

import java.sql.*;
import java.util.Base64;
import java.util.List;

@RestController
public class ControlersLogin {
 DataBase dataBase = new DataBase();

@PostMapping("/login")
@ResponseBody
    public User login(@RequestParam String email, @RequestParam String password) {
    String encodedPassword = Base64.getEncoder().encodeToString(password.getBytes());
    return dataBase.loginVerication(email,encodedPassword);

    }



}
