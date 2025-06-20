package com.example.VerificationJWT.databases;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.sql.SQLException;

public class DatabaseExceptionTest {
//    @Test
    public void testConnectionDatabase()  {
        DataBase dataBase = new DataBase();
        assertThrows(SQLException.class, () -> {
//            dataBase.connection("jdbc:mysql://localhost:3306/DatabasesJwt", "wrongUser", "wrongPassword");
        });
    }

}
