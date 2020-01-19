package com.fredrikpedersen.dependencyinjectiondemo.controllers.withSpring;

import com.fredrikpedersen.services.farewell.FarewellService;
import com.fredrikpedersen.services.greeting.GreetingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;

/**
 * @author Fredrik Pedersen
 * @version 1.0
 * @since: 15/01/2020 at 12:28
 *
 * Controller for demonstrating constructor injection with Spring.
 * Note: constructor injected beans does not need to autowire it's dependencies. It is however good practice for clarity to mark the constructor with @Autowired
 * Note: FarewellService is not part of the course, just part of me toying with @Qualifier
 */

@Controller
public class ConstructorInjectedController {

    private GreetingService greetingService;
    private FarewellService farewellService;

    @Autowired
    public ConstructorInjectedController(@Qualifier("constructor") GreetingService greetingService, @Qualifier("constructor") FarewellService farewellService) {
        this.greetingService = greetingService;
        this.farewellService = farewellService;
    }

    public String sayHello() {
        return greetingService.sayGreeting();
    }

    public String sayGoodbye() {
        return farewellService.sayFarewell();
    }
}
