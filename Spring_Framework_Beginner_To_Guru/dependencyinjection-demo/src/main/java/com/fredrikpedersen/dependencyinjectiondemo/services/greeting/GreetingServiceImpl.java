package com.fredrikpedersen.dependencyinjectiondemo.services.greeting;

import org.springframework.stereotype.Service;

/**
 * @author Fredrik Pedersen
 * @version 1.0
 * @since: 15/01/2020 at 12:23
 */

@Service
public class GreetingServiceImpl implements GreetingService {

    public static final String GREETINGS = "Greetings from Impl";

    @Override
    public String sayGreeting() {
        return GREETINGS;
    }
}
