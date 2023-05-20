package com.ecommerce.commercial.config;

import java.security.Key;
import java.util.Date;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;

public class JwtConfig {

    private static final long EXPIRATION_TIME = 36000000L; // Expiration time in milliseconds

    public static String generateJwt(String username) {
        Date now = new Date();
        Date expirationDate = new Date(now.getTime() + EXPIRATION_TIME);

        Key key = Keys.secretKeyFor(SignatureAlgorithm.HS512);

        return Jwts.builder()
                .setSubject(username)
                .setIssuedAt(now)
                .setExpiration(expirationDate)
                .signWith(key)
                .compact();
    }

    public static boolean validateJwt(String jwt) {
        try {
            Key key = Keys.secretKeyFor(SignatureAlgorithm.HS512);
            Jwts.parserBuilder()
                    .setSigningKey(key)
                    .build()
                    .parseClaimsJws(jwt);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public static void main(String[] args) {
        String jwt = generateJwt("username");
        System.out.println("Generated JWT: " + jwt);

        boolean isValid = validateJwt(jwt);
        System.out.println("Is JWT valid? " + isValid);
    }
}
