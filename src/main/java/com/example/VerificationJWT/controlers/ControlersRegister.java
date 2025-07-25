    package com.example.VerificationJWT.controlers;

import com.example.VerificationJWT.databases.DataBase;

import com.example.VerificationJWT.response.Response;
import com.example.VerificationJWT.response.ResponseCreateUsers;
import com.example.VerificationJWT.response.ResponseErorr;
import com.example.VerificationJWT.services.User;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLException;
import java.util.Base64;


    @RestController
public class ControlersRegister {
        DataBase dataBase = new DataBase();



        @PostMapping("/register")
        @ResponseBody
        public Response Register(@RequestParam String email, @RequestParam String user, @RequestParam String password, @RequestParam String city) throws SQLException {
            String encodedPassword = Base64.getEncoder().encodeToString(password.getBytes());

            if (email.isEmpty() || user.isEmpty() || password.isEmpty() || city.isEmpty()) {
                return new ResponseErorr(
                        "failure",
                        404,
                        "Not Found",
                        "complete all fields"
                );
            }
            if (email.equals(dataBase.getUserEmail(email))) {
                return new ResponseErorr(
                        "failure",
                        409,
                        "conflict in the database",
                        "email exits"
                );
            }
            if (user.equals(dataBase.getUserName(user))) {
                return new ResponseErorr(
                        "failure",
                        409,
                        "conflict in the database",
                        "user exits"
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


            User userCreated = dataBase.database(email, user, encodedPassword, city);

            return new ResponseCreateUsers(
                    "User created successfully",
                    "ok",
                    200,
                    "Created"
            );
        }
//    @PostMapping("/user")
//    @ResponseBody
//    public Object verificationUser ( @RequestParam int num){
//        if (num < dataBase.getUserSize()) {
//            return dataBase.getUserById(num);
//        } else {
//            return new Response(
//                    "failure",
//                    404,
//                    "Not Found"
//            );
//        }
//    }
//
//        public static final String keyServer = "@siuuuuuu76543562 67876543443 234563437";
//        @PostMapping("/login")
//        @ResponseBody
//        public Response login(@RequestParam String email, @RequestParam String password) {
//        final int expirationTokenMinutes = 50;
//        String encodedPassword = Base64.getEncoder().encodeToString(password.getBytes());
//        User user = dataBase.getUserByEmail(email);
//        if(email.equals(user.getEmail()) && encodedPassword.equals(user.getPassword())){
//            System.out.printf("\n"+ user.getEmail() + " " + user.getPassword());
//            HashMap<String, Object> userData = new HashMap<>();
//            userData.put("id", user.getId());
//            Date expirationToken = new Date(System.currentTimeMillis() + expirationTokenMinutes * 60 * 1000);
//            String jwt = Jwts.builder()
//                    .header()
//                    .type("JWT")
//                    .and()
//                    .setSubject(user.getName())
//                    .expiration(expirationToken)
//                    .claims(userData)
//                    .signWith(key(), Jwts.SIG.HS256)
//                    .compact();
//            System.out.printf(jwt);
//            String encodedJwt = Base64.getEncoder().encodeToString(jwt.getBytes(StandardCharsets.UTF_8));
//            return new ResponseToken(
//                    "successful process",
//                    200,
//                    "authentication complete",
//                    jwt
//            );
//        }
//        return new ResponseErorr(
//                "Error",
//                400,
//                "not found",
//                "User not found"
//        );
//    }
//        public SecretKey key() {
//            return Keys.hmacShaKeyFor(keyServer.getBytes());
//        }
//    }
    }





