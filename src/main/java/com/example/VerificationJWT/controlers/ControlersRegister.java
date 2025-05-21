    package com.example.VerificationJWT.controlers;

import com.example.VerificationJWT.databases.DataBases;
import com.example.VerificationJWT.response.Response;
import com.example.VerificationJWT.response.ResponseErorr;
import com.example.VerificationJWT.services.Users;
import org.springframework.web.bind.annotation.*;

import java.util.Base64;
import java.util.List;

@RestController
public class ControlersRegister {
    DataBases dataBases = new DataBases();


    @PostMapping("/")
    @ResponseBody
    public Object Register(@RequestParam String email, @RequestParam String user, @RequestParam String password,@RequestParam String city) {
        int id = 0;
        if (email.isEmpty() || user.isEmpty() || password.isEmpty() || city.isEmpty()) {
            return new ResponseErorr(
                    "failure",
                    404,
                    "Not Found",
                    "complete all fields"
            );
        }
            if (email.contains("@") && email.contains(".")) {
                if (password.length() > 6) {
                    boolean uppercases = false;
                    boolean lowercases = false;
                    boolean numbers = false;
                    char c;
                    for (int i = 0; i < password.length(); i++) {
                        c = password.charAt(i);
                       if (Character.isUpperCase(c))
                           uppercases = true;
                        if (Character.isLowerCase(c))
                            lowercases = true;
                        if (Character.isDigit(c))
                            numbers = true;
                    }
                    if (uppercases) {
                        String encodedEmail = Base64.getEncoder().encodeToString(email.getBytes());
                        String encodedUser = Base64.getEncoder().encodeToString(user.getBytes());
                        String encodedPassword = Base64.getEncoder().encodeToString(password.getBytes());
                        for (int i = 0;i < dataBases.getSizeList();i++){
                            id++;
                        }

                        return dataBases.databases(id,email, user, encodedPassword,city);

                    } else {
                        return new ResponseErorr(
                                "failure",
                                404,
                                "Not Found",
                                "The password is insecure"
                        );
                    }
                } else {
                    return new ResponseErorr(
                            "failure",
                            404,
                            "Not Found",
                            "the password has six characters"
                    );
                }


            } else {
                return new ResponseErorr(
                        "failure",
                        404,
                        "Not Found",
                        "enter a valid address"
                );
            }
    }






        @PostMapping("/user")
        @ResponseBody
        public Object verificationUser ( @RequestParam int num){
            if (num < dataBases.getSizeList()) {
                return dataBases.getUsers(num);
            } else {
                return new Response(
                        "failure",
                        404,
                        "Not Found"
                );
            }
        }
    }


