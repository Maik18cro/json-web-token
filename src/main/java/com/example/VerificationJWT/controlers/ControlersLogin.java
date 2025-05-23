package com.example.VerificationJWT.controlers;

import com.example.VerificationJWT.databases.DataBase;
import org.springframework.web.bind.annotation.RestController;

import java.util.Base64;
import java.util.List;

@RestController
public class ControlersLogin {

    DataBase dataBase = new DataBase(
            "email@email.com",
            "Admin",
            "Pass",
            "Bogota"
    );
//    @PostMapping("/login")
//    @ResponseBody
//    public Response login(@RequestParam String email, @RequestParam String password) {
//        String encodedPassword = Base64.getEncoder().encodeToString(password.getBytes());
//        User user = dataBase.getUserByEmail(email);
//        System.out.println(email);
//        System.out.println(user.getEmail());
//        if(user != null && user.getEmail().equals(email)){
//            return new  Response(
//                    "",
//                    200,
//                    ""
//            );
//        }
//        return new ResponseErorr(
//                "Error",
//                400,
//                "not found",
//                "User not found"
//        );
//
//    }
}
