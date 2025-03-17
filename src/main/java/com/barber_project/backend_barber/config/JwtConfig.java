package com.barber_project.backend_barber.config;

import io.jsonwebtoken.security.Keys;
import java.security.Key;

public class JwtConfig {
    public static Key getSigningKey() {
        return Keys.secretKeyFor(io.jsonwebtoken.SignatureAlgorithm.HS256);
    }
}