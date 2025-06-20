package com.example.VerificationJWT.response;

import com.example.VerificationJWT.databases.DataBase;
import com.example.VerificationJWT.services.User;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class ResponseTests {

    @Nested
    class TestsResponseUsers  {
        @Test
        public void testResponseUsers() {
            DataBase dataBase = new DataBase();
            User user = new User(0, "paco@mail.con", "paco", "123SCW@wd4","Barcelona");
            Response response = dataBase.getUserData(user.getId());






        }

        }

}
