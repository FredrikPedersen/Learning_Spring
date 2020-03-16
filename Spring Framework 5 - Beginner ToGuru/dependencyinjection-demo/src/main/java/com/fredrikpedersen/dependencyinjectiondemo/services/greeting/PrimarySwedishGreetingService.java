package com.fredrikpedersen.dependencyinjectiondemo.services.greeting;

/**
 * @author Fredrik Pedersen
 * @version 1.0
 * @since 15/01/2020 at 16:56
 */

public class PrimarySwedishGreetingService implements GreetingService {

    GreetingRepository greetingRepository;

    public PrimarySwedishGreetingService(GreetingRepository greetingRepository) {
        this.greetingRepository = greetingRepository;
    }

    @Override
    public String sayGreeting() {
        return greetingRepository.getSwedishGreeting();
    }
}
