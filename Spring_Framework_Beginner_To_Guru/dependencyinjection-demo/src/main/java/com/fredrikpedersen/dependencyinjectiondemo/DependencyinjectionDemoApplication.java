package com.fredrikpedersen.dependencyinjectiondemo;

import com.fredrikpedersen.dependencyinjectiondemo.controllers.withSpring.ConstructorInjectedController;
import com.fredrikpedersen.dependencyinjectiondemo.controllers.withSpring.MyController;
import com.fredrikpedersen.dependencyinjectiondemo.controllers.withSpring.SetterInjectedController;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages= {"com.fredrikpedersen.services", "com.fredrikpedersen.dependencyinjectiondemo"})
public class DependencyinjectionDemoApplication {

    public static void main(String[] args) {

        ApplicationContext ctx = SpringApplication.run(DependencyinjectionDemoApplication.class, args);

        MyController controller = (MyController)ctx.getBean("myController");

        System.out.println(controller.hello());
        System.out.println(ctx.getBean(SetterInjectedController.class).sayHello());
        System.out.println(ctx.getBean(ConstructorInjectedController.class).sayHello());
        System.out.println(ctx.getBean(ConstructorInjectedController.class).sayGoodbye());
    }
}
