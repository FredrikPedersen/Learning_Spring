package com.fredrikpedersen.dependencyinjectiondemo.controllers.noSpring;

import com.fredrikpedersen.dependencyinjectiondemo.services.greeting.GreetingService;

/**
 * @author Fredrik Pedersen
 * @version 1.0
 * @since: 15/01/2020 at 12:27
 *
 * Controller for demonstrating setter injection without Spring
 */
public class SetterInjectedControllerNS {

    private GreetingService greetingService;

    String sayHello() {
        return greetingService.sayGreeting();
    }

    public void setGreetingService(GreetingService greetingService) {
        this.greetingService = greetingService;
    }
}
