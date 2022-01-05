package com.fredrikpedersen.jdbcTemplate.dao.mappers;

import com.fredrikpedersen.jdbcTemplate.domain.Author;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class AuthorMapper implements RowMapper<Author> {

    @Override
    public Author mapRow(final ResultSet resultSet, final int i) throws SQLException {
        final Author author = Author.builder()
                .firstName(resultSet.getString("first_name"))
                .lastName(resultSet.getString("last_name"))
                .build();

        author.setId(resultSet.getLong("id"));
        return author;
    }
}
