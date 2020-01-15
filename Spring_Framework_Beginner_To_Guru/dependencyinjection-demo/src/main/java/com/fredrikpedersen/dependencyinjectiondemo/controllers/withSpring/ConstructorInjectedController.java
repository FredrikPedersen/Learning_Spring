package com.fredrikpedersen.dependencyinjectiondemo.controllers.withSpring;

import com.fredrikpedersen.dependencyinjectiondemo.services.GreetingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

/**
 * @author Fredrik Pedersen
 * @version 1.0
 * Created: 15/01/2020 at 12:28
 *
 * Controller for demonstrating constructor injection with Spring.
 * Note, constructor injected beans does not need to autowire it's dependencies. It is however good practice for clarity to mark the constructor with @Autowired
 */

@Controller
public class ConstructorInjectedController {

    private GreetingService greetingService;

    @Autowired
    public ConstructorInjectedController(GreetingService greetingService) {
        this.greetingService = greetingService;
    }

    public String sayHello() {
        return greetingService.sayGreeting();
    }
}
