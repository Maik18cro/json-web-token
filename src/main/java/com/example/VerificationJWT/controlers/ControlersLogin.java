package com.example.VerificationJWT.controlers;

import com.example.VerificationJWT.databases.DataBases;
import com.example.VerificationJWT.response.Response;
import com.example.VerificationJWT.response.ResponseErorr;
import com.example.VerificationJWT.response.ResponseUsers;
import com.example.VerificationJWT.services.User;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Base64;

@RestController
public class ControlersLogin {
    DataBases dataBases = new DataBases(
            "email@email.com",
            "Admin",
            "Pass",
            "Bogota"
    );

    @PostMapping("/login")
    @ResponseBody
    public Response login(@RequestParam String email, @RequestParam String password) {
        String encodedPassword = Base64.getEncoder().encodeToString(password.getBytes());
        User user = dataBases.getUserByEmail(email);
        if(user == null) {
            return new ResponseErorr(
                "Error",
                400,
                "not found",
                "User not found"
            );
        }

        return null;
    }
}
