package com.isc517final.microservices.users.Utils;

import java.math.BigInteger;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;

public final class Parser {

    public static String getHashedPassword(String password) {

        String hashPassword = null;
        MessageDigest hasher = null;

        try {
            hasher = MessageDigest.getInstance("SHA-512");
            hasher.reset();
            hasher.update(password.getBytes(StandardCharsets.UTF_8));
            hashPassword = String.format("%0128x", new BigInteger(1, hasher.digest()));

        } catch (Exception e) {
            e.printStackTrace();
        }

        return hashPassword;
    }

    public static boolean comparePassword(String password, String hashToCompare) {

        String hashPassword = getHashedPassword(password);

        return hashPassword.equals(hashToCompare);
    }
}
