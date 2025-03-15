package com.barber_project.backend_barber.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
            .csrf(csrf -> csrf.disable()) // Desativa CSRF (útil para APIs REST)
            .authorizeHttpRequests(auth -> auth
                .requestMatchers("/profissionais/**","/servicos/**","/usuarios/**").permitAll() // Permite acesso aos endpoints de usuários
                .anyRequest().authenticated() // Exige autenticação para outros endpoints
            );

        return http.build();
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}