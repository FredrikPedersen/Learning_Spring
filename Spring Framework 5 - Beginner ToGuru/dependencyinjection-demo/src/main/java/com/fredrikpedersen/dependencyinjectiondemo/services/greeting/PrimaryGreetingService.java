package com.fredrikpedersen.dependencyinjectiondemo.services.greeting;

/**
 * @author Fredrik Pedersen
 * @version 1.0
 * @since: 15/01/2020 at 13:17
 */

public class PrimaryGreetingService implements GreetingService {

    private GreetingRepository greetingRepository;

    public PrimaryGreetingService(GreetingRepository greetingRepository) {
        this.greetingRepository = greetingRepository;
    }

    @Override
    public String sayGreeting() {
        return greetingRepository.getEnglishGreeting();
    }
}
