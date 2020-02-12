package com.fredrikpedersen.dependencyinjectiondemo.config;

import com.fredrikpedersen.dependencyinjectiondemo.services.greeting.GreetingRepository;
import com.fredrikpedersen.dependencyinjectiondemo.services.greeting.GreetingService;
import com.fredrikpedersen.dependencyinjectiondemo.services.greeting.GreetingServiceFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.Profile;

/**
 * @author Fredrik Pedersen
 * @version 1.0
 * @since 21/01/2020 at 13:42
 */

@Configuration
public class GreetingServiceConfig {

    @Bean
    GreetingServiceFactory greetingServiceFactory(GreetingRepository greetingRepository) {
        return new GreetingServiceFactory(greetingRepository);
    }

    @Bean
    @Primary
    @Profile({"default", "en"})
    GreetingService primaryGreetingService(GreetingServiceFactory greetingServiceFactory) {
        return greetingServiceFactory.createGreetingService("en");
    }

    @Bean
    @Primary
    @Profile("no")
    GreetingService primaryNorwegianGreetingService(GreetingServiceFactory greetingServiceFactory) {
        return greetingServiceFactory.createGreetingService("no");
    }

    @Bean
    @Primary
    @Profile("se")
    GreetingService primarySwedishGreetingService(GreetingServiceFactory greetingServiceFactory) {
        return greetingServiceFactory.createGreetingService("se");
    }

}
