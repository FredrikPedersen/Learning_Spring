package com.fredrikpedersen.dependencyinjectiondemo;

import com.fredrikpedersen.dependencyinjectiondemo.controllers.withSpring.ConstructorInjectedController;
import com.fredrikpedersen.dependencyinjectiondemo.controllers.withSpring.MyController;
import com.fredrikpedersen.dependencyinjectiondemo.controllers.withSpring.SetterInjectedController;
import com.fredrikpedersen.dependencyinjectiondemo.examplebeans.FakeDataSource;
import com.fredrikpedersen.dependencyinjectiondemo.examplebeans.FakeJmsBroker;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
public class DependencyinjectionDemoApplication {

    public static void main(String[] args) {

        ApplicationContext ctx = SpringApplication.run(DependencyinjectionDemoApplication.class, args);

        MyController controller = (MyController)ctx.getBean("myController");
        FakeDataSource fakeDataSource = ctx.getBean(FakeDataSource.class);

        System.out.println(fakeDataSource.getUser());

        FakeJmsBroker fakeJmsBroker = ctx.getBean(FakeJmsBroker.class);
        System.out.println(fakeJmsBroker.getUsername());
    }
}
