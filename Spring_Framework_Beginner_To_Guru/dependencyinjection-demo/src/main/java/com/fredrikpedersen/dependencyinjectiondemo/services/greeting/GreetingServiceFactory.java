package com.fredrikpedersen.dependencyinjectiondemo.services.greeting;

/**
 * @author Fredrik Pedersen
 * @version 1.0
 * @since 21/01/2020 at 13:44
 */
public class GreetingServiceFactory {

    private GreetingRepository greetingRepository;

    public GreetingServiceFactory(GreetingRepository greetingRepository) {
        this.greetingRepository = greetingRepository;
    }

    public GreetingService createGreetingService(String language) {

        switch (language) {
            case "en":
                return new PrimaryGreetingService(greetingRepository);
            case "no":
                return new PrimaryNorwegianGreetingService(greetingRepository);
            case "se":
                return new PrimarySwedishGreetingService(greetingRepository);
            default:
                return new PrimaryGreetingService(greetingRepository);
        }
    }
}
