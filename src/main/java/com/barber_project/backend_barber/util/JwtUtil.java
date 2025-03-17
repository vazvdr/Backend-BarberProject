package com.barber_project.backend_barber.util;

import java.security.Key;
import java.util.Date;

import org.springframework.stereotype.Component;

import com.barber_project.backend_barber.config.JwtConfig;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;

@Component
public class JwtUtil {
    private static final Key SECRET_KEY = JwtConfig.getSigningKey();

    public static String generateToken(String subject) {
        return Jwts.builder()
                .setSubject(subject)
                .setIssuedAt(new Date())
                .setExpiration(new Date(System.currentTimeMillis() + 86400000))
                .signWith(SECRET_KEY)
                .compact();
    }

    // Validação do token
    public static Claims validateToken(String token) {
        return Jwts.parserBuilder()
                .setSigningKey(SECRET_KEY)
                .build()
                .parseClaimsJws(token)
                .getBody();
    }

    // Verifica se o token está expirado
    public static boolean isTokenExpired(String token) {
        return validateToken(token).getExpiration().before(new Date());
    }

    // Recupera o sujeito (subject) do token
    public static String extractSubject(String token) {
        return validateToken(token).getSubject();
    }
}
