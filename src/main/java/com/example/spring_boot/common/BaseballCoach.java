package com.example.spring_boot.common;

import org.springframework.stereotype.Component;

@Component
public class BaseballCoach implements Coach {
    @Override
    public String getDailyWorkout() {
        return "Baseball Coach daily workout";
    }
}
