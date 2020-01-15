package com.fredrikpedersen.dependencyinjectiondemo.controllers;

        import com.fredrikpedersen.dependencyinjectiondemo.services.GreetingServiceImpl;
        import org.junit.Before;
        import org.junit.Test;

        import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * @author Fredrik Pedersen
 * @version 1.0
 * Created: 15/01/2020 at 12:32
 */
public class PropertyInjectedControllerTest {

    private PropertyInjectedController propertyInjectedController;

    @Before
    public void setUp() throws Exception {
        this.propertyInjectedController = new PropertyInjectedController();
        this.propertyInjectedController.greetingService = new GreetingServiceImpl();
    }

    @Test
    public void testGreeting() throws Exception {
        assertEquals(GreetingServiceImpl.GREETINGS, propertyInjectedController.sayHello());
    }
}
