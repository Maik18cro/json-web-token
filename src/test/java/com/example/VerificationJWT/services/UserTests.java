package com.example.VerificationJWT.services;

import com.example.VerificationJWT.controlers.ControlersRegister;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class UserTests {
        public static User user = new User(4, "crumaik@.com", "crumaik", "12345678", "Bucuresti");
    @Test
    public void testUser() {
        ControlersRegister register = new ControlersRegister();
        assertEquals(4, user.getId());
        assertEquals("crumaik@.com", user.getEmail());
        assertEquals("crumaik", user.getName());
        assertEquals("12345678", user.getPassword());
        assertEquals("Bucuresti", user.getCity());
        assertInstanceOf(Integer.class, user.getId());
        assertInstanceOf(String.class, user.getEmail());
        assertInstanceOf(String.class, user.getName());
        assertInstanceOf(String.class, user.getPassword());
        assertInstanceOf(String.class, user.getCity());

    }
}
