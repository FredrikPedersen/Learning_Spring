package com.fredrikpedersen.dependencyinjectiondemo.controllers.noSpring;

import com.fredrikpedersen.dependencyinjectiondemo.services.greeting.GreetingServiceImpl;
import org.junit.Before;
import org.junit.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * @author Fredrik Pedersen
 * @version 1.0
 * Created: 15/01/2020 at 12:36
 */
public class ConstructorInjectedControllerNSTest {

    private ConstructorInjectedControllerNS constructorInjectedController;

    @Before
    public void setUp() throws Exception {
        this.constructorInjectedController = new ConstructorInjectedControllerNS(new GreetingServiceImpl());
    }

    @Test
    public void testGreeting() throws Exception {
        assertEquals(GreetingServiceImpl.GREETINGS, constructorInjectedController.sayHello());
    }
}
