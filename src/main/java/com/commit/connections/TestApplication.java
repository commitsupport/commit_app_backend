package com.commit.connections;

import com.commit.connections.security.PasswordHasher;

public class TestApplication {

    public static void main(String[] args) {

        PasswordHasher hasher = new PasswordHasher();
        String password = "tongle";
        String password2 = "000";

        System.out.println(password + ": " + hasher.hashPassword(password));
        System.out.println(password2 + ": " + hasher.hashPassword(password2));
    }
}
