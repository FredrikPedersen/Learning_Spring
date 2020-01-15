package com.fredrikpedersen.dependencyinjectiondemo.controllers.withSpring;

import com.fredrikpedersen.dependencyinjectiondemo.services.greeting.GreetingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;

/**
 * @author Fredrik Pedersen
 * @version 1.0
 * @since: 15/01/2020 at 12:21
 *
 * Controller for demonstrating property injection with Spring
 */

@Controller
public class PropertyInjectedController {

    @Autowired
    @Qualifier("greetingServiceImpl") //Using the precise class name to invoke the reflection API to find the correct dependency.
    public GreetingService greetingService;

    public String sayHello() {
        return greetingService.sayGreeting();
    }
}
