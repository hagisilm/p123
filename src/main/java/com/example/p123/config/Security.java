package com.example.p123.config;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@EnableWebSecurity
@Configuration
@Slf4j
public class Security {


    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) {
        try {
            return http.csrf().disable()
                    .authorizeRequests()
                    .mvcMatchers("/admin/**").hasRole("ADMIN")
                    .anyRequest()
                    .permitAll()
                    .and()
                    .formLogin()
                    .loginPage("/users/login")
                    .loginProcessingUrl("/login")
                    .defaultSuccessUrl("/")
                    .failureUrl("/users/login/error")
                    .and().build();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

}
