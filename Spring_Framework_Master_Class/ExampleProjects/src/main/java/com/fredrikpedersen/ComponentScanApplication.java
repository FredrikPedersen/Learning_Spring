package com.fredrikpedersen;

import componentScan.ComponentPersonDAO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan("componentScan") //Do this to find beans in other packages.
public class ComponentScanApplication {

    private final static Logger LOGGER = LoggerFactory.getLogger(ComponentScanApplication.class);

    public static void main(String[] args) {

        ApplicationContext applicationContext = SpringApplication.run(ComponentScanApplication.class, args);

        ComponentPersonDAO personDAO = applicationContext.getBean(ComponentPersonDAO.class);

        LOGGER.info("{}", personDAO);
        LOGGER.info("{}", personDAO.getComponentJdbcConnection());
    }
}