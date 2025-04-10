package com.infor.platform.civabackend.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http
                .csrf(csrf -> csrf.disable())
                .authorizeHttpRequests(auth -> auth
                        .requestMatchers("/bus/**").authenticated() // protege /bus
                        .anyRequest().permitAll() // el resto se permite sin auth
                )
                .httpBasic(Customizer.withDefaults()); // autenticación
        return http.build();
    }
}
