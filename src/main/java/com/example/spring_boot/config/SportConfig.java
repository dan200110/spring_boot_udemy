package com.example.spring_boot.config;

import com.example.spring_boot.common.Coach;
import com.example.spring_boot.common.SwimCoach;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SportConfig {
    @Bean("aquatic")
    public Coach swimCoach() {
        return new SwimCoach();
    }
}
