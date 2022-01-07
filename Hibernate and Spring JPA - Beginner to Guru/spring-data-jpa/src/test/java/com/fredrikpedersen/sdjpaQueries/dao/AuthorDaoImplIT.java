package com.fredrikpedersen.sdjpaQueries.dao;

import com.fredrikpedersen.sdjpaQueries.domain.Author;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.orm.jpa.JpaObjectRetrievalFailureException;
import org.springframework.test.context.ActiveProfiles;

import javax.persistence.EntityNotFoundException;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
@ActiveProfiles("local")
@ComponentScan(basePackages = {"com.fredrikpedersen.sdjpaQueries.dao"})
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
class AuthorDaoImplIT {

    @Autowired
    private AuthorDao authorDao;

    @Test
    void findById() {

        final Author author = authorDao.findById(1L);

        assertNotNull(author);
        assertEquals(1L, author.getId());
    }

    @Test
    void findByName() {

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
    void save() {

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
    void update() {

        //given
        final String correctLastName = "Pedersen";
        final Author savedAuthor = authorDao.save(new Author("Fredrik", "P"));

        //when
        savedAuthor.setLastName(correctLastName);
        final Author updatedAuthor = authorDao.update(savedAuthor);

        //then
        assertEquals(savedAuthor, updatedAuthor);
        assertThrows(EntityNotFoundException.class, () -> authorDao.findByName("Fredrik", "P"));
    }

    @Test
    void deleteById() {

        //given
        final Author savedAuthor = authorDao.save(new Author("Fredrik", "Deletesen"));

        //when
        authorDao.deleteById(savedAuthor.getId());

        //then
        assertThrows(JpaObjectRetrievalFailureException.class, () -> authorDao.findById(savedAuthor.getId()));
    }


}