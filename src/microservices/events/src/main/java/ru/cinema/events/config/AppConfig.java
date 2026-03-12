package ru.cinema.events.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.security.SecureRandom;

@Configuration
public class AppConfig {

    @Bean
    SecureRandom secureRandom() {
        return new SecureRandom();
    }

}

