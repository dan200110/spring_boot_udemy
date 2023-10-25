package com.example.spring_boot.common;

public class SwimCoach implements Coach{
    public SwimCoach(){
        System.out.println("In constructor: " + getClass().getSimpleName());
    }
    @Override
    public String getDailyWorkout() {
        return "Swim coach as a warm up";
    }
}
