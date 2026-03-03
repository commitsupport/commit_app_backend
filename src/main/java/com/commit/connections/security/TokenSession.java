package com.commit.connections.security;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.util.Base64;

public final class TokenSession {

    private static final SecureRandom RNG = new SecureRandom();

    // prywatny konstruktor: nie da się zrobić new TokenGenerator()
    private TokenSession() {}

    public static String generateToken() {
        byte[] bytes = new byte[32];
        RNG.nextBytes(bytes);
        return Base64.getUrlEncoder()
                .withoutPadding()
                .encodeToString(bytes);
    }

    public static String hashToken(String token) {
        if (token == null || token.isBlank()) {
            throw new IllegalArgumentException("Token cannot be null/blank");
        }
        try {
            MessageDigest md = MessageDigest.getInstance("SHA-256");   // algorytm SHA-256
            byte[] digest = md.digest(token.getBytes(StandardCharsets.UTF_8)); // hash bajtów tokena
            return Base64.getEncoder().encodeToString(digest); // zamiana hasha (32 bajty) na Base64 string
        } catch (NoSuchAlgorithmException e) {
            throw new IllegalStateException("SHA-256 not available", e);
        }
    }
}
