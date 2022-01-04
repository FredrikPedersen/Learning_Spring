package com.fredrikpedersen.jdbc.dao;

import com.fredrikpedersen.jdbc.domain.Author;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.transaction.annotation.Transactional;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
@Transactional
@ActiveProfiles("local")
@ComponentScan(basePackages = {"com.fredrikpedersen.jdbc.dao"})
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
class AuthorDaoImplIT {

    @Autowired
    private AuthorDao authorDao;

    @Test
    void testFindAuthorById() {

        final Author author = authorDao.findById(1L);

        assertNotNull(author);
        assertEquals(1L, author.getId());
    }

    @Test
    void testFindAuthorByName() {

        //given
        final Author expectedAuthor = new Author("Brandon", "Sanderson");

        //when
        final Author actualAuthor = authorDao.findByName("Brandon", "Sanderson");

        //then
        assertNotNull(actualAuthor);
        assertEquals(expectedAuthor.getFirstName(), actualAuthor.getFirstName());
        assertEquals(expectedAuthor.getLastName(), actualAuthor.getLastName());
        assertNotNull(actualAuthor.getId());
    }

    @Test
    void testSaveAuthor() {

        //given
        final Author author = new Author("Fredrik", "Pedersen");

        //when
        final Author savedAuthor = authorDao.save(author);

        //then
        assertNotNull(savedAuthor);
        assertEquals(author.getFirstName(), savedAuthor.getFirstName());
        assertEquals(author.getLastName(), savedAuthor.getLastName());
        assertNotNull(savedAuthor.getId());
    }


}