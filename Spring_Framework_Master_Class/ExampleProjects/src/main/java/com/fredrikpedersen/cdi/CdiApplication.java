package com.fredrikpedersen.cdi;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class CdiApplication {


    private final static Logger LOGGER = LoggerFactory.getLogger(CdiApplication.class);

    public static void main(String[] args) {

        ApplicationContext applicationContext = SpringApplication.run(CdiApplication.class, args);

        CdiBusiness cdiBusiness = applicationContext.getBean(CdiBusiness.class);

        LOGGER.info("\nBusiness: {} \nDAO: {}", cdiBusiness, cdiBusiness.getCdiDao());
    }
}
