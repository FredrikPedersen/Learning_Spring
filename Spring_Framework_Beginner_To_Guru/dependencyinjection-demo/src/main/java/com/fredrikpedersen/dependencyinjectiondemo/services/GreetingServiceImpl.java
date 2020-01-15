package com.fredrikpedersen.dependencyinjectiondemo.services;

import org.springframework.stereotype.Service;

/**
 * @author Fredrik Pedersen
 * @version 1.0
 * Created: 15/01/2020 at 12:23
 */

@Service
public class GreetingServiceImpl implements GreetingService {

    public static final String GREETINGS = "Greetings";

    @Override
    public String sayGreeting() {
        return GREETINGS;
    }
}
