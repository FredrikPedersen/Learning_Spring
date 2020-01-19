package com.fredrikpedersen.services.greeting;

import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

/**
 * @author Fredrik Pedersen
 * @version 1.0
 * @since 15/01/2020 at 16:49
 */

@Service
@Profile("no")
@Primary
public class PrimaryNorwegianGreetingService implements GreetingService {

        @Override
        public String sayGreeting() {
            return "Hei, jeg er den norske hilsnings tjenesten";
        }
}
