package com.fredrikpedersen.dependencyinjectiondemo.services;

/**
 * @author Fredrik Pedersen
 * @version 1.0
 * Created: 15/01/2020 at 12:23
 */
public class GreetingServiceImpl implements GreetingService {

    public static final String GREETINGS = "Greetings";

    @Override
    public String sayGreeting() {
        return GREETINGS;
    }
}
