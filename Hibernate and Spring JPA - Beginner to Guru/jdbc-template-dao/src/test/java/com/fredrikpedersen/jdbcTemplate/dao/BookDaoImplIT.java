package com.fredrikpedersen.jdbcTemplate.dao;

import com.fredrikpedersen.jdbcTemplate.domain.Book;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.test.context.ActiveProfiles;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
@ActiveProfiles("local")
@ComponentScan(basePackages = {"com.fredrikpedersen.jdbcTemplate.dao"})
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
class BookDaoImplIT {

    @Autowired
    private BookDao bookDao;

    @Nested
    class CrudTests {

        @Test
        void findAll() {
            final List<Book> books = bookDao.findAll();

            assertNotNull(books);
            assertTrue(books.size() > 1);
        }

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
            assertThrows(EmptyResultDataAccessException.class, () -> bookDao.findByTitle("King of Horns"));
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
            final boolean isDeleted = bookDao.deleteById(savedBook.getId());

            //then
            assertTrue(isDeleted);
            assertThrows(EmptyResultDataAccessException.class, () -> bookDao.findById(savedBook.getId()));
        }

    }


    @Nested
    class ManualPagingTests {

        @Test
        void findAllPage1() {
            final List<Book> books = bookDao.findAll(10, 0);

            assertNotNull(books);
            assertEquals(10, books.size());
        }

        @Test
        void findAllPage2() {
            final List<Book> books = bookDao.findAll(10, 10);

            assertNotNull(books);
            assertEquals(10, books.size());
        }

        @Test
        void findAllPage10() {
            final List<Book> books = bookDao.findAll(10, 100); //Offset exceeding max number of records returns empty list

            assertNotNull(books);
            assertEquals(0, books.size());
        }
    }

    @Nested
    class PageableTests {

        @Test
        void findAllPage1() {
            final List<Book> books = bookDao.findAll(PageRequest.of(0, 10));

            assertNotNull(books);
            assertEquals(10, books.size());
        }

        @Test
        void findAllPage1_SortByTitle() {
            final List<Book> books = bookDao.findAllSortByTitle(
                    PageRequest.of(0, 10, Sort.by(Sort.Order.desc("title"))
            ));

            assertNotNull(books);
            assertEquals(10, books.size());
        }

        @Test
        void findAllPage2() {
            final List<Book> books = bookDao.findAll(PageRequest.of(1, 10));

            assertNotNull(books);
            assertEquals(10, books.size());
        }

        @Test
        void findAllPage10() {
            final List<Book> books = bookDao.findAll(PageRequest.of(10, 10)); //Offset exceeding max number of records returns empty list

            assertNotNull(books);
            assertEquals(0, books.size());
        }
    }
}