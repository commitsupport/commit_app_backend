package com.commit.connections.security;

import org.mindrot.jbcrypt.BCrypt;

public class PasswordHasher {

    private static final int WORKLOAD = 12;

    public String hashPassword(String password) {
        if(password == null || password.isBlank()) {
            throw new IllegalArgumentException("Password cannot be null!");
        }
        String salt = BCrypt.gensalt(WORKLOAD);
        return BCrypt.hashpw(password, salt);
    }

    public boolean checkPassword(String password, String hashedPassword) {
        if (password == null || hashedPassword == null) {
            return false;
        }
        return BCrypt.checkpw(password, hashedPassword);
    }
}
