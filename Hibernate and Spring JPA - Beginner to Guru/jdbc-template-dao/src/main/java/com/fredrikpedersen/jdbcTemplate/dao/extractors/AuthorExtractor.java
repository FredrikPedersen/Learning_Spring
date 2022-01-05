package com.fredrikpedersen.jdbcTemplate.dao.extractors;

import com.fredrikpedersen.jdbcTemplate.dao.mappers.AuthorMapper;
import com.fredrikpedersen.jdbcTemplate.domain.Author;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.ResultSetExtractor;

import java.sql.ResultSet;
import java.sql.SQLException;

public class AuthorExtractor implements ResultSetExtractor<Author> {

    @Override
    public Author extractData(final ResultSet resultSet) throws SQLException, DataAccessException {
        return new AuthorMapper().mapRow(resultSet, 0);
    }
}
