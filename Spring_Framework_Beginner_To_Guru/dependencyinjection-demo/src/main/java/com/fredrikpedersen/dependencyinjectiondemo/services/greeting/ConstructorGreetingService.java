package com.fredrikpedersen.dependencyinjectiondemo.services.greeting;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

/**
 * @author Fredrik Pedersen
 * @version 1.0
 * Created: 15/01/2020 at 13:02
 */

@Service
@Qualifier("constructor")
public class ConstructorGreetingService implements GreetingService {

     @Override
    public String sayGreeting() {
         return "Hello, I was injected via the constructor";
     }
}
