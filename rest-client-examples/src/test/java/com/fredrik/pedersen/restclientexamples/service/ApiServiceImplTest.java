package com.fredrik.pedersen.restclientexamples.service;

import com.fredrik.pedersen.api.domain.User;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author Fredrik Pedersen
 * @version 1.0
 * @since 13/02/2020 at 22:10
 */

@ExtendWith(SpringExtension.class)
@SpringBootTest
class ApiServiceImplTest {

    @Autowired
    ApiService apiService;

    @BeforeEach
    void setUp() {
    }

    @Test
    void getUsers() {
        List<User> users = apiService.getUsers(4);

        assertEquals(3, users.size());
    }
}