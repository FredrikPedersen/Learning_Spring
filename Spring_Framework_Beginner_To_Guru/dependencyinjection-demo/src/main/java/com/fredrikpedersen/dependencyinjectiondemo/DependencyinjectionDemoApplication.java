package com.fredrikpedersen.dependencyinjectiondemo;

import com.fredrikpedersen.dependencyinjectiondemo.controllers.MyController;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class DependencyinjectionDemoApplication {

    public static void main(String[] args) {

        ApplicationContext ctx = SpringApplication.run(DependencyinjectionDemoApplication.class, args);

        MyController controller = (MyController)ctx.getBean("myController");
        controller.hello();
    }
}
