package com.example.spring_boot.common;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Lazy;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
/*@Lazy*/
@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
public class TrackCoach implements Coach {
    public TrackCoach() {
        System.out.println("In constructor: " + getClass().getSimpleName());
    }

    // define our init method
/*    @PostConstruct
    public  void doMyStartupStuff() {
        System.out.println("In doMyStartupStuff: " + getClass().getSimpleName()) ;
    }
    // define our destroy method
    @PreDestroy
    public void doMyCleanupStuff() {
        System.out.println("In doMyCleanupStuff: " + getClass().getSimpleName()) ;
    }*/
    @Override
    public String getDailyWorkout() {
        return "Track Coach daily workout";
    }
}
