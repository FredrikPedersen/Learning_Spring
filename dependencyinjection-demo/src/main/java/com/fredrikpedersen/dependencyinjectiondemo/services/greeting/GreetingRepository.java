package com.fredrikpedersen.dependencyinjectiondemo.services.greeting;

/**
 * @author Fredrik Pedersen
 * @version 1.0
 * @since 21/01/2020 at 13:49
 */

public interface GreetingRepository {

    String getEnglishGreeting();
    String getNorwegianGreeting();
    String getSwedishGreeting();
}
