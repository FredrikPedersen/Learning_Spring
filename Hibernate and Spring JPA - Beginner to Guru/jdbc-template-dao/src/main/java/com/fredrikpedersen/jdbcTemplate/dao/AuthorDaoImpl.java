package com.fredrikpedersen.jdbcTemplate.dao;

import com.fredrikpedersen.jdbcTemplate.dao.mappers.AuthorMapper;
import com.fredrikpedersen.jdbcTemplate.domain.Author;
import lombok.RequiredArgsConstructor;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;


@Component
@RequiredArgsConstructor
public class AuthorDaoImpl implements AuthorDao {

    private final JdbcTemplate jdbcTemplate;

    @Override
    public Author findById(final Long id) {
        return null;
    }

    @Override
    public Author findByName(final String firstName, final String lastName) {
        return null;
    }

    @Override
    public Author save(final Author author) {
        return null;
    }

    @Override
    public Author update(final Author author) {
        return null;
    }

    @Override
    public boolean deleteById(final Long id) {
        return false;
    }

    private RowMapper<Author> getRowMapper() {
        return new AuthorMapper();
    }
}
