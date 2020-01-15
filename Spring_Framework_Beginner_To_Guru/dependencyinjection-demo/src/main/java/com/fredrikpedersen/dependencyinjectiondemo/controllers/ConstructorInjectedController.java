package com.fredrikpedersen.dependencyinjectiondemo.controllers;

import com.fredrikpedersen.dependencyinjectiondemo.services.GreetingService;

/**
 * @author Fredrik Pedersen
 * @version 1.0
 * Created: 15/01/2020 at 12:28
 *
 * Controller for demonstrating constructor injection without Spring
 */
public class ConstructorInjectedController {

    private GreetingService greetingService;

    public ConstructorInjectedController(GreetingService greetingService) {
        this.greetingService = greetingService;
    }

    String sayHello() {
        return greetingService.sayGreeting();
    }
}
