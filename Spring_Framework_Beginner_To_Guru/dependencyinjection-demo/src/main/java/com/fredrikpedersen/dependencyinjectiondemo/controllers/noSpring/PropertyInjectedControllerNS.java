package com.fredrikpedersen.dependencyinjectiondemo.controllers.noSpring;

import com.fredrikpedersen.dependencyinjectiondemo.services.greeting.GreetingServiceImpl;

/**
 * @author Fredrik Pedersen
 * @version 1.0
 * Created: 15/01/2020 at 12:21
 *
 * Controller for demonstrating property injection without Spring
 */

public class PropertyInjectedControllerNS {

    public GreetingServiceImpl greetingService;

    String sayHello() {
        return greetingService.sayGreeting();
    }
}
