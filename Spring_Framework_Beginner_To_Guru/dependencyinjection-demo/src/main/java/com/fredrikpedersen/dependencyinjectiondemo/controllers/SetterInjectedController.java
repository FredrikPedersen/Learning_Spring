package com.fredrikpedersen.dependencyinjectiondemo.controllers;

import com.fredrikpedersen.dependencyinjectiondemo.services.GreetingService;

/**
 * @author Fredrik Pedersen
 * @version 1.0
 * Created: 15/01/2020 at 12:27
 *
 * Controller for demonstrating setter injection without Spring
 */
public class SetterInjectedController {

    private GreetingService greetingService;

    String sayHello() {
        return greetingService.sayGreeting();
    }

    public void setGreetingService(GreetingService greetingService) {
        this.greetingService = greetingService;
    }
}
