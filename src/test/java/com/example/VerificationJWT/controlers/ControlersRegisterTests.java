package com.example.VerificationJWT.controlers;

import com.example.VerificationJWT.databases.DataBase;
import com.example.VerificationJWT.response.Response;
import com.example.VerificationJWT.response.ResponseTests;
import com.example.VerificationJWT.response.ResponseCreateUsers;
import com.example.VerificationJWT.response.ResponseErorr;
import com.example.VerificationJWT.services.User;

import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;

import java.sql.SQLException;


public class ControlersRegisterTests {
    public static void Register() throws SQLException {
        ControlersRegister register = new ControlersRegister();
        Response response = register.Register("crumaik@gmail.com", "maik", "15Maik3409", "Bucuresti");

    }

    @Test
    public void testEmpty() throws SQLException {
        ControlersRegister register = new ControlersRegister();
        User user = new User(5, "", "", "", "");
        assertTrue(user.getEmail().isEmpty());
        assertTrue(user.getName().isEmpty());
        assertTrue(user.getPassword().isEmpty());
        assertTrue(user.getCity().isEmpty());
        Response response = register.Register("", "", "", "");
        assertInstanceOf(ResponseErorr.class, response);
        assertEquals("failure", response.getStatus());
        assertEquals(404, response.getStatusCode());
        assertEquals("Not Found", response.getMessage());
    }

    @Test
    public void testUserCreated() throws SQLException {
        ControlersRegister register = new ControlersRegister();
        Response responseUser = register.Register("crumaik@gmail.com", "maik", "15Maik3409", "Bucuresti");
        assertInstanceOf(ResponseCreateUsers.class, responseUser);
        ResponseCreateUsers responseCreateUsers = (ResponseCreateUsers) responseUser;
        assertEquals("User created successfully", responseCreateUsers.getData());


    }

    @Test
    public void testNameExist() throws SQLException {
        ControlersRegister register = new ControlersRegister();
        DataBase dataBase = new DataBase();
        ControlersRegisterTests.Register();
        Response responseEmailExist = register.Register("pacoDom@gmail.com", "maik", "23modm34", "Amsterdam");
        assertInstanceOf(ResponseErorr.class, responseEmailExist);
        ResponseErorr responseErorr = (ResponseErorr) responseEmailExist;
        assertEquals("user exits", responseErorr.getError());
    }

    @Test
    public void testEmailValidWithSign() throws SQLException {
        ControlersRegister register = new ControlersRegister();
        DataBase dataBase = new DataBase();
        ControlersRegisterTests.Register();
        Response responseEmailValid = register.Register("pacoDomgmail.com", "paco", "23modm34", "Amsterdam");
        assertInstanceOf(ResponseErorr.class, responseEmailValid);

    }

    @Test
    public void testEmailValidWithSpot() throws SQLException {
        ControlersRegister register = new ControlersRegister();
        DataBase dataBase = new DataBase();
        ControlersRegisterTests.Register();
        Response responseEmailValid = register.Register("pacoDomgmail@com", "paco", "23modm34", "Amsterdam");
        assertInstanceOf(ResponseErorr.class, responseEmailValid);
    }

    @Test
    public void testPasswordElderlyToSixCharacters() throws SQLException {
        ControlersRegister register = new ControlersRegister();
        DataBase dataBase = new DataBase();
        ControlersRegisterTests.Register();
        Response responsePassword = register.Register("pacoDomgmail@.com", "paco", "23m3f", "Amsterdam");
        assertInstanceOf(ResponseErorr.class, responsePassword);
    }

    @Test
    public void testPasswordSecureNumbers() throws SQLException {
        ControlersRegister register = new ControlersRegister();
        DataBase dataBase = new DataBase();
        ControlersRegisterTests.Register();
        Response responsePasswordSecure = register.Register("pacoDomgmail@.com", "paco", "233455543", "Amsterdam");
        assertInstanceOf(ResponseErorr.class, responsePasswordSecure);
    }

    @Test
    public void testPasswordSecureUppercase() throws SQLException {
        ControlersRegister register = new ControlersRegister();
        DataBase dataBase = new DataBase();
        ControlersRegisterTests.Register();
        Response responsePasswordSecure = register.Register("pacoDomgmail@.com", "paco", "ERFGBRTRGR", "Amsterdam");
        assertInstanceOf(ResponseErorr.class, responsePasswordSecure);

    }

    @BeforeEach
    public void beforeEachTest() throws SQLException {
        DataBase dataBase = new DataBase();
        int id = dataBase.getId("crumaik@gmail.com");
        dataBase.deleteUser(id);
    }
}
