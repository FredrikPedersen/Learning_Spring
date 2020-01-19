package com.fredrikpedersen.services.greeting;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

/**
 * @author Fredrik Pedersen
 * @version 1.0
 * @since: 15/01/2020 at 13:03
 */

@Service
@Qualifier("setter")
public class SetterGreetingService implements GreetingService {

    @Override
    public String sayGreeting() {
        return "Hello, I was injected by the setter";
    }
}
