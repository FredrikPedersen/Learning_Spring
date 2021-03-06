package com.fredrikpedersen.dependencyinjectiondemo.controllers.noSpring;

import com.fredrikpedersen.dependencyinjectiondemo.services.greeting.GreetingServiceImpl;
import org.junit.Before;
import org.junit.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * @author Fredrik Pedersen
 * @version 1.0
 * @since: 15/01/2020 at 12:35
 */
public class SetterInjectedControllerNSTest {

    private SetterInjectedControllerNS setterInjectedController;

    @Before
    public void setUp() throws Exception {
        this.setterInjectedController = new SetterInjectedControllerNS();
        this.setterInjectedController.setGreetingService(new GreetingServiceImpl()); //Here it is possible to instantiate the controller without the GreetingService, leading to a null pointer.
    }

    @Test
    public void testGreeting() throws Exception {
        assertEquals(GreetingServiceImpl.GREETINGS, setterInjectedController.sayHello());
    }
}
