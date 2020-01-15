package com.fredrikpedersen.dependencyinjectiondemo.controllers.withSpring;

import com.fredrikpedersen.dependencyinjectiondemo.services.greeting.GreetingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;

/**
 * @author Fredrik Pedersen
 * @version 1.0
 * Created: 15/01/2020 at 12:27
 *
 * Controller for demonstrating setter injection with Spring
 */
@Controller
public class SetterInjectedController {

    private GreetingService greetingService;

    public String sayHello() {
        return greetingService.sayGreeting();
    }

    @Autowired
    @Qualifier("setter")
    public void setGreetingService(GreetingService greetingService) {
        this.greetingService = greetingService;
    }
}
