package com.fredrikpedersen.dependencyinjectiondemo.controllers;

import com.fredrikpedersen.dependencyinjectiondemo.services.greeting.GreetingService;
import org.springframework.stereotype.Controller;

/**
 * @author Fredrik Pedersen
 * @version 1.0
 * Created: 15/01/2020 at 11:26
 */

@Controller
public class MyController {

    private GreetingService greetingService;

    public MyController(GreetingService greetingService) {
        this.greetingService = greetingService;
    }

    public String hello() {
        return  greetingService.sayGreeting();
    }
}
