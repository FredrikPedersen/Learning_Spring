package com.fredrikpedersen.dependencyinjectiondemo.services.greeting;

import org.springframework.stereotype.Component;

/**
 * @author Fredrik Pedersen
 * @version 1.0
 * @since 21/01/2020 at 13:49
 */

@Component
public class GreetingRepositoryImpl implements GreetingRepository {
    @Override
    public String getEnglishGreeting() {
        return "Hello - Primary Greeting Service";
    }

    @Override
    public String getNorwegianGreeting() {
        return "Hei - Primære Hilsetjeneste";
    }

    @Override
    public String getSwedishGreeting() {
        return "Tjänare grabben, nu kjör vi!";
    }
}
