package com.fredrikpedersen.jdbc.dao;

import com.fredrikpedersen.jdbc.domain.Author;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.test.context.ActiveProfiles;

import static org.junit.jupiter.api.Assertions.assertNotNull;

@DataJpaTest
@ActiveProfiles("local")
@ComponentScan(basePackages = {"com.fredrikpedersen.jdbc.dao"})
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
class AuthorDaoImplIT {

    @Autowired
    private AuthorDao authorDao;

    @Test
    void testGetAuthor() {

        final Author author = authorDao.getById(1L);

        assertNotNull(author);
    }

}