package com.fredrikpedersen.services.greeting;

import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

/**
 * @author Fredrik Pedersen
 * @version 1.0
 * @since: 15/01/2020 at 13:17
 */

@Service
@Profile({"en","default"})
@Primary
public class PrimaryGreetingService implements GreetingService {

    @Override
    public String sayGreeting() {
        return "Hello, Primary Greeting Service";
    }
}
