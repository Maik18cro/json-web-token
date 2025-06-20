package com.example.VerificationJWT.controlers;

import com.example.VerificationJWT.response.Response;
import com.example.VerificationJWT.response.ResponseTests;
import com.example.VerificationJWT.response.ResponseErorr;
import org.junit.jupiter.api.Test;

import java.sql.SQLException;

import static org.junit.jupiter.api.Assertions.*;

public class ControlersLginTests {
    @Test
    public void testLoginEmpty() throws SQLException {
        ControlersLogin login = new ControlersLogin();
       Response response = login.login("","");
       assertInstanceOf(ResponseErorr.class, response);
    }

    @Test
    public void testLogin() throws SQLException {
        ControlersRegister register = new ControlersRegister();
        ControlersLogin login = new ControlersLogin();
        register.Register("crumaik@gmail.com", "maik", "15Maik3409", "Bucuresti");
        Response response = login.login("crumaik@.com", "15Maik3409");
        assertInstanceOf(Response.class, response);
    }
}
