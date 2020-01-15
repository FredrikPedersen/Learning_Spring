package com.fredrikpedersen.dependencyinjectiondemo.services;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

/**
 * @author Fredrik Pedersen
 * @version 1.0
 * Created: 15/01/2020 at 13:03
 */

@Service
@Qualifier("setter")
public class SetterGreetingService implements GreetingService {

    @Override
    public String sayGreeting() {
        return "Hello, I was injected by the setter";
    }
}
