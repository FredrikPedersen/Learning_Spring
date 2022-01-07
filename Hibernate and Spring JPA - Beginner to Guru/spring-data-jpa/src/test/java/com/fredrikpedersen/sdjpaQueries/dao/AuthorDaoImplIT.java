package com.fredrikpedersen.sdjpaQueries.dao;

import com.fredrikpedersen.sdjpaQueries.domain.Author;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.test.context.ActiveProfiles;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
@ActiveProfiles("local")
@ComponentScan(basePackages = {"com.fredrikpedersen.sdjpaQueries.dao"})
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
class AuthorDaoImplIT {

    @Autowired
    private AuthorDao authorDao;

    @Test
    void testFindById() {

        final Author author = authorDao.findById(1L);

        assertNotNull(author);
        assertEquals(1L, author.getId());
    }

    @Test
    void testFindByName() {

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
    void testSave() {

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

    @Test
    void testUpdate() {

        //given
        final String correctLastName = "Pedersen";
        final Author savedAuthor = authorDao.save(new Author("Fredrik", "P"));

        //when
        savedAuthor.setLastName(correctLastName);
        final Author updatedAuthor = authorDao.update(savedAuthor);

        //then
        assertEquals(savedAuthor, updatedAuthor);
        assertThrows(EmptyResultDataAccessException.class, () -> authorDao.findByName("Fredrik", "P"));
    }

    @Test
    void testDelete() {

        //given
        final Author savedAuthor = authorDao.save(new Author("Fredrik", "Deletesen"));

        //when
        final boolean isDeleted = authorDao.deleteById(savedAuthor.getId());

        //then
        assertTrue(isDeleted);
    }


}