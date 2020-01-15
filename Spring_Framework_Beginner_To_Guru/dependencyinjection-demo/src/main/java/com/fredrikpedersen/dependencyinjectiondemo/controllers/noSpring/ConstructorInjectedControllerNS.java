package com.fredrikpedersen.dependencyinjectiondemo.controllers.noSpring;

import com.fredrikpedersen.dependencyinjectiondemo.services.greeting.GreetingService;

/**
 * @author Fredrik Pedersen
 * @version 1.0
 * Created: 15/01/2020 at 12:28
 *
 * Controller for demonstrating constructor injection without Spring
 */
public class ConstructorInjectedControllerNS {

    private GreetingService greetingService;

    public ConstructorInjectedControllerNS(GreetingService greetingService) {
        this.greetingService = greetingService;
    }

    String sayHello() {
        return greetingService.sayGreeting();
    }
}
