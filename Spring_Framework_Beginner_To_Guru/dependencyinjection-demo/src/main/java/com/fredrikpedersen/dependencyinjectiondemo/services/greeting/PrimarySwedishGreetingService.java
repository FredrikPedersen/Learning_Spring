package com.fredrikpedersen.dependencyinjectiondemo.services.greeting;

import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

/**
 * @author Fredrik Pedersen
 * @version 1.0
 * @since 15/01/2020 at 16:56
 */

@Service
@Primary
@Profile("se")
public class PrimarySwedishGreetingService implements GreetingService {

    @Override
    public String sayGreeting() {
        return "Tjänare grabben";
    }
}
