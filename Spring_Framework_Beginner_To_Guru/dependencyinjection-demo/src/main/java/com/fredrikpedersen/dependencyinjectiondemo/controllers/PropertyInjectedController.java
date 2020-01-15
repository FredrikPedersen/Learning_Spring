package com.fredrikpedersen.dependencyinjectiondemo.controllers;

import com.fredrikpedersen.dependencyinjectiondemo.services.GreetingServiceImpl;

/**
 * @author Fredrik Pedersen
 * @version 1.0
 * Created: 15/01/2020 at 12:21
 *
 * Controller for demonstrating property injection without Spring
 */

public class PropertyInjectedController {

    public GreetingServiceImpl greetingService;

    String sayHello() {
        return greetingService.sayGreeting();
    }
}
