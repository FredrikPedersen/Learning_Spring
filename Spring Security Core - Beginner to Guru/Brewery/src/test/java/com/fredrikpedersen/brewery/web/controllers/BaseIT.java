package com.fredrikpedersen.brewery.web.controllers;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.provider.Arguments;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import java.util.stream.Stream;

import static org.springframework.security.test.web.servlet.setup.SecurityMockMvcConfigurers.springSecurity;

public abstract class BaseIT {

    protected static final String ROLE_ADMIN_NAME = "admin";
    protected static final String ROLE_CUSTOMER_NAME = "customer";
    protected static final String ROLE_USER_NAME = "user";
    protected static final String PASSWORD = "password";

    @Autowired
    protected WebApplicationContext wac;

    protected MockMvc mockMvc;

    @BeforeEach
    public void setup() {
        mockMvc = MockMvcBuilders
                .webAppContextSetup(wac)
                .apply(springSecurity())
                .build();
    }

    public static Stream<Arguments> getStreamAdminCustomer() {
        return Stream.of(Arguments.of(ROLE_CUSTOMER_NAME, PASSWORD),
                Arguments.of(ROLE_ADMIN_NAME, PASSWORD));
    }

    public static Stream<Arguments> getStreamAllUsers() {
        return Stream.of(Arguments.of(ROLE_ADMIN_NAME , PASSWORD),
                Arguments.of(ROLE_CUSTOMER_NAME, PASSWORD),
                Arguments.of(ROLE_USER_NAME, PASSWORD));
    }

    public static Stream<Arguments> getStreamNotAdmin() {
        return Stream.of(Arguments.of(ROLE_CUSTOMER_NAME, PASSWORD),
                Arguments.of(ROLE_USER_NAME, PASSWORD));
    }
}
