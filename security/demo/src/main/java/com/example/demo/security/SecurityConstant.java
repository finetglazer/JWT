package com.example.demo.security;

import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;

import java.security.Key;

public class SecurityConstant {
    public static final Key key = Keys.secretKeyFor(SignatureAlgorithm.HS512);
    public static final long EXPIRATION_TIME = 900_000; // 15 minutes
}
