package com.fredrikpedersen.jdbcTemplate.dao;

import com.fredrikpedersen.jdbcTemplate.dao.mappers.BookMapper;
import com.fredrikpedersen.jdbcTemplate.domain.Book;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Component;

import java.sql.PreparedStatement;
import java.sql.Statement;
import java.util.List;

import static com.fredrikpedersen.jdbcTemplate.dao.Queries.*;

@Component
@RequiredArgsConstructor
public class BookDaoImpl implements BookDao {

    private final JdbcTemplate jdbcTemplate;

    @Override
    public List<Book> findAll() {
        return jdbcTemplate.query(SELECT_ALL_BOOKS, getBookMapper());
    }

    @Override
    public List<Book> findAll(final int pageSize, final int offset) {
        return jdbcTemplate.query(SELECT_ALL_BOOKS_PAGING_SORTING, getBookMapper(), pageSize, offset);
    }

    @Override
    public List<Book> findAll(final Pageable pageable) {
        return jdbcTemplate.query(SELECT_ALL_BOOKS_PAGING_SORTING,
                getBookMapper(),
                pageable.getPageSize(),
                pageable.getOffset());
    }

    @Override
    public List<Book> findAllSortByTitle(final Pageable pageable) {
        final String query = "SELECT * FROM book ORDER BY title "
                + pageable.getSort().getOrderFor("title").getDirection().name()
                + " LIMIT ? OFFSET ?";

        return jdbcTemplate.query(query, getBookMapper(), pageable.getPageSize(), pageable.getOffset());
    }

    @Override
    public Book findById(final Long id) {
        return jdbcTemplate.queryForObject(SELECT_BOOK_BY_ID, getBookMapper(), id);
    }

    @Override
    public Book findByTitle(final String title) {
        return jdbcTemplate.queryForObject(SELECT_BOOK_BY_TITLE, getBookMapper(), title);
    }

    @Override
    public Book save(final Book book) {
        final KeyHolder keyHolder = new GeneratedKeyHolder();

        jdbcTemplate.update(connection -> {
            final PreparedStatement statement = connection.prepareStatement(INSERT_BOOK, Statement.RETURN_GENERATED_KEYS);

            statement.setString(1, book.getIsbn());
            statement.setString(2, book.getPublisher());
            statement.setString(3, book.getTitle());
            statement.setLong(4, book.getAuthorId());

            return statement;
        }, keyHolder);

        return this.findById(keyHolder.getKey().longValue());
    }

    @Override
    public Book update(final Book book) {
        jdbcTemplate.update(connection -> {
            final PreparedStatement statement = connection.prepareStatement(UPDATE_BOOK);
            statement.setString(1, book.getIsbn());
            statement.setString(2, book.getPublisher());
            statement.setString(3, book.getTitle());
            statement.setLong(4, book.getAuthorId());
            statement.setLong(5, book.getId());

            return statement;
        });

        return this.findById(book.getId());
    }

    @Override
    public boolean deleteById(final Long id) {
        final int affectedRows = jdbcTemplate.update(DELETE_BOOK_BY_ID, id);

        return affectedRows == 1;
    }

    private BookMapper getBookMapper() {
        return new BookMapper();
    }
}
