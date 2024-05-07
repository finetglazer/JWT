package com.example.demo.security;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.jetbrains.annotations.NotNull;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
public class JWTGenerator {
    public String generateToken(@NotNull Authentication authentication) {
        String username = authentication.getName();
        Date currentDate = new Date();
        Date expirationDate = new Date(currentDate.getTime() + SecurityConstant.EXPIRATION_TIME);

        return Jwts.builder()
                .setSubject(username)
                .setIssuedAt(currentDate)
                .setExpiration(expirationDate)
                .signWith(SignatureAlgorithm.HS512, SecurityConstant.key)
                .compact();
    }

    public String getUserNameFromJWT(String token) {
        return Jwts.parser().setSigningKey(SecurityConstant.key).parseClaimsJws(token).getBody().getSubject();
    }

    public boolean validateToken(String token) {
        try {
//            Claims claims
            Jwts.parser().setSigningKey(SecurityConstant.key).parseClaimsJws(token);
            return true;
        } catch (Exception e) {
            System.out.println("Invalid JWT token");
        }
        return false;
    }
}
