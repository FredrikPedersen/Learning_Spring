package com.fredrikpedersen.jdbcTemplate.dao.mappers;

import com.fredrikpedersen.jdbcTemplate.domain.Author;
import com.fredrikpedersen.jdbcTemplate.domain.Book;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class AuthorMapper implements RowMapper<Author> {

    @Override
    public Author mapRow(final ResultSet resultSet, final int rowNumber) throws SQLException {
        if (!resultSet.next()) {
            return null;
        } else {
            final Author author = Author.builder()
                    .firstName(resultSet.getString("first_name"))
                    .lastName(resultSet.getString("last_name"))
                    .build();

            author.setId(resultSet.getLong("id"));

            if (resultSet.getString("title") != null) {
                author.setBoooks(new ArrayList<>());
                author.getBoooks().add(mapBook(resultSet));
            }

            while (resultSet.next()) {
                author.getBoooks().add(mapBook(resultSet));
            }

            return author;
        }

    }

    private Book mapBook(final ResultSet resultSet) throws SQLException {
        final Book book = new Book();
        book.setId(resultSet.getLong("book_id"));
        book.setIsbn(resultSet.getString("isbn"));
        book.setPublisher(resultSet.getString("publisher"));
        book.setTitle(resultSet.getString("title"));
        book.setAuthorId(resultSet.getLong("id"));
        return book;
    }
}
