package com.fredrikpedersen.sdjpaQueries.dao;

import com.fredrikpedersen.sdjpaQueries.domain.Book;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.orm.jpa.JpaObjectRetrievalFailureException;
import org.springframework.test.context.ActiveProfiles;

import javax.persistence.EntityNotFoundException;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
@ActiveProfiles("local")
@ComponentScan(basePackages = {"com.fredrikpedersen.sdjpaQueries.dao"})
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
class BookDaoImplIT {

    @Autowired
    private BookDao bookDao;

    @Nested
    class CrudTests {

        @Test
        void findById() {

            final Book book = bookDao.findById(1L);

            assertNotNull(book);
            assertEquals(1L, book.getId());
        }

        @Test
        void findByTitle() {

            //given
            final Book expectedBook = new Book("The Way of Kings", "978-0-7653-2635-5", "Tor Books", 1L);

            //when
            final Book actualBook = bookDao.findByTitle("The Way of Kings");

            //then
            assertNotNull(actualBook);
            assertEquals(expectedBook.getTitle(), actualBook.getTitle());
            assertNotNull(actualBook.getId());

        }

        @Test
        void save() {

            //given
            final Book book = new Book("Mogworld", "123-0-4567-8910-5", "Dark Horse", 1L);

            //when
            final Book savedBook = bookDao.save(book);

            //then
            assertNotNull(savedBook);
            assertEquals(book.getTitle(), savedBook.getTitle());
            assertEquals(book.getIsbn(), savedBook.getIsbn());
            assertEquals(book.getPublisher(), savedBook.getPublisher());
            assertEquals(book.getAuthorId(), savedBook.getAuthorId());
            assertNotNull(savedBook.getId());
        }

        @Test
        void update() {

            //given
            final String correctTitle = "Prince of Thorns";
            final Book savedBook = bookDao.save(new Book("King of Horns", "123-0-4567-8910-5", "Harper Voyager", 1L));
            savedBook.setTitle(correctTitle);

            //when
            final Book updatedBook = bookDao.update(savedBook);

            //then
            assertNotNull(correctTitle, updatedBook.getTitle());
            assertThrows(EntityNotFoundException.class, () -> bookDao.findByTitle("King of Horns"));
        }

        @Test
        void deleteById() {

            //given
            final Book savedBook = bookDao.save(Book.builder()
                    .title("Ghosts of Onyx")
                    .isbn("123-0-4567-8910-5")
                    .publisher("Tor Books")
                    .authorId(1L)
                    .build());

            //when
            bookDao.deleteById(savedBook.getId());

            //then
            assertThrows(JpaObjectRetrievalFailureException.class, () -> bookDao.findById(savedBook.getId()));
        }

        @Test
        void findAll() {
            List<Book> books = bookDao.findAll();

            assertNotNull(books);
            assertTrue(books.size() > 1);
        }
    }

    @Nested
    class ManualPagingTest {

        @Test
        void findAllBooksPage1() {
            List<Book> books = bookDao.findAll(10, 0);

            assertNotNull(books);
            assertEquals(10, books.size());
        }

        @Test
        void findAllBooksPage2() {
            List<Book> books = bookDao.findAll(10, 10);

            assertNotNull(books);
            assertEquals(10, books.size());
        }

        @Test
        void findAllBooksPage10() {
            List<Book> books = bookDao.findAll(10, 100);

            assertNotNull(books);
            assertEquals(10, books.size());
        }

    }

    @Nested
    class PageableTests {

        @Test
        void findAllBooksPage1_SortByTitle() {
            final List<Book> books = bookDao.findAllSortByTitle(PageRequest.of(0, 10,
                    Sort.by(Sort.Order.desc("title"))));

            assertNotNull(books);
            assertEquals(10, books.size());
        }

        @Test
        void findAllBooksPage1_pageable() {
            final List<Book> books = bookDao.findAll(PageRequest.of(0, 10));

            assertNotNull(books);
            assertEquals(10, books.size());
        }

        @Test
        void findAllBooksPage2_pageable() {
            final List<Book> books = bookDao.findAll(PageRequest.of(1, 10));

            assertNotNull(books);
            assertEquals(10, books.size());
        }

        @Test
        void findAllBooksPage10_pageable() {
            final List<Book> books = bookDao.findAll(PageRequest.of(10, 10));

            assertNotNull(books);
            assertEquals(10, books.size());
        }
    }


}