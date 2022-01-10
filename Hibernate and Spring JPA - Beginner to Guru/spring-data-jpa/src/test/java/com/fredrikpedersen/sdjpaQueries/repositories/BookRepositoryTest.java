package com.fredrikpedersen.sdjpaQueries.repositories;

import com.fredrikpedersen.sdjpaQueries.domain.Book;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.test.context.ActiveProfiles;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.atomic.AtomicInteger;

import static org.junit.jupiter.api.Assertions.*;


@DataJpaTest
@ActiveProfiles("local")
@ComponentScan(basePackages = {"com.fredrikpedersen.sdjpaQueries.repositories"})
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
class BookRepositoryTest {

    @Autowired
    private BookRepository bookRepository;

    @Test
    void emptyResultException() {
        assertThrows(EmptyResultDataAccessException.class, () -> bookRepository.readByTitle("foobar"));
    }

    @Test
    void nullParam() {
        assertNull(bookRepository.getByTitle(null));
    }

    @Test
    void noException() {
        assertNull(bookRepository.getByTitle("foobar"));
    }

    @Test
    void streamByTitle() {
        final AtomicInteger count = new AtomicInteger();

        bookRepository.findAlLByTitleNotNull().forEach(book -> count.incrementAndGet());

        assertTrue(count.get() > 1);
    }

    @Test
    void bookFutureAsync() throws ExecutionException, InterruptedException {
        final Future<Book> bookFuture = bookRepository.queryByTitle("The Way of Kings");

        final Book book = bookFuture.get();

        assertNotNull(book);
    }


}