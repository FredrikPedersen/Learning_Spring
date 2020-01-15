package com.fredrikpedersen.dependencyinjectiondemo.services.greeting;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

/**
 * @author Fredrik Pedersen
 * @version 1.0
 * Created: 15/01/2020 at 13:17
 */

@Service
@Primary
public class PrimaryGreetingService implements GreetingService {

    @Override
    public String sayGreeting() {
        return "Hello, Primary Greeting Service";
    }
}
