package com.fredrikpedersen.dependencyinjectiondemo.controllers.noSpring;

        import com.fredrikpedersen.services.greeting.GreetingServiceImpl;
        import org.junit.Before;
        import org.junit.Test;

        import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * @author Fredrik Pedersen
 * @version 1.0
 * @since: 15/01/2020 at 12:32
 */
public class PropertyInjectedControllerNSTest {

    private PropertyInjectedControllerNS propertyInjectedController;

    @Before
    public void setUp() throws Exception {
        this.propertyInjectedController = new PropertyInjectedControllerNS();
        this.propertyInjectedController.greetingService = new GreetingServiceImpl();
    }

    @Test
    public void testGreeting() throws Exception {
        assertEquals(GreetingServiceImpl.GREETINGS, propertyInjectedController.sayHello());
    }
}
