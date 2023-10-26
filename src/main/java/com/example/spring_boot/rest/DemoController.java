package com.example.spring_boot.rest;

import com.example.spring_boot.common.Coach;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DemoController {
    // define a private field for the dependency
    private Coach myCoach;
  /*  private Coach anotherCoach;*/
    // define a constructor for dependency injection
    @Autowired
    public DemoController(
            @Qualifier("aquatic") Coach theCoach)
            /*, @Qualifier("trackCoach") Coach theAnotherCoach)*/ {

        myCoach = theCoach;
       /* anotherCoach = theAnotherCoach;*/
    }

    @GetMapping("/daily_workout")
    public String getDailyWorkout() {
        return myCoach.getDailyWorkout();
    }

    /*@GetMapping("check")
    public String check() {
        return "Comparing beans myCoach == anotherCoach, " + (myCoach == anotherCoach);
    }*/
}
