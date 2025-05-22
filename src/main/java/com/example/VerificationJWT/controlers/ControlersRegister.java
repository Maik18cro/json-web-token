    package com.example.VerificationJWT.controlers;

import com.example.VerificationJWT.databases.DataBases;
import com.example.VerificationJWT.response.Response;
import com.example.VerificationJWT.response.ResponseErorr;
import com.example.VerificationJWT.response.ResponseUsers;
import com.example.VerificationJWT.services.User;
import org.springframework.web.bind.annotation.*;

import java.util.Base64;

@RestController
public class ControlersRegister {
    DataBases dataBases = new DataBases(
            "email@email.com",
            "Admin",
            "Pass",
            "Bogota"
    );
    @PostMapping("/register")
    @ResponseBody
    public Response Register(@RequestParam String email, @RequestParam String user, @RequestParam String password,@RequestParam String city) {


        if (email.isEmpty() || user.isEmpty() || password.isEmpty() || city.isEmpty()) {
            return new ResponseErorr(
                    "failure",
                    404,
                    "Not Found",
                    "complete all fields"
            );
        }

        if (!email.contains("@") || !email.contains(".")) {
            return new ResponseErorr(
                    "failure",
                    404,
                    "Not Found",
                    "enter a valid address"
            );
        }

        if (password.length() <= 6) {
            return new ResponseErorr(
                    "failure",
                    404,
                    "Not Found",
                    "the password has six characters"
            );
        }

        boolean uppercases = false;
        boolean lowercases = false;
        boolean numbers = false;
        char caracter;

        for (int i = 0; i < password.length(); i++) {
            caracter = password.charAt(i);
            if (Character.isUpperCase(caracter))
                uppercases = true;
            if (Character.isLowerCase(caracter))
                lowercases = true;
            if (Character.isDigit(caracter))
                numbers = true;
        }

        if (!uppercases || !lowercases || !numbers) {
            return new ResponseErorr(
                    "failure",
                    404,
                    "Not Found",
                    "The password is insecure"
            );
        }

        String encodedEmail = Base64.getEncoder().encodeToString(email.getBytes());
        String encodedUser = Base64.getEncoder().encodeToString(user.getBytes());
        String encodedPassword = Base64.getEncoder().encodeToString(password.getBytes());

        User userCreated = dataBases.createNewUser(email, user, encodedPassword,city);

        return new ResponseUsers(
                userCreated,
                "ok",
                200,
                "all is OK"
        );
    }

//    @PostMapping("/user")
//    @ResponseBody
//    public Object verificationUser ( @RequestParam int num){
//        if (num < dataBases.getSizeList()) {
//            return dataBases.getUsersById(num);
//        } else {
//            return new Response(
//                    "failure",
//                    404,
//                    "Not Found"
//            );
//        }
//    }
    }



