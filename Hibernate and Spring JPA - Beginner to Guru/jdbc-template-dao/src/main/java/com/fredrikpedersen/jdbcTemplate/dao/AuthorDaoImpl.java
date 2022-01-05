package com.fredrikpedersen.jdbcTemplate.dao;

import com.fredrikpedersen.jdbcTemplate.dao.mappers.AuthorMapper;
import com.fredrikpedersen.jdbcTemplate.domain.Author;
import lombok.RequiredArgsConstructor;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Component;

import java.sql.PreparedStatement;
import java.sql.Statement;

import static com.fredrikpedersen.jdbcTemplate.dao.Queries.*;


@Component
@RequiredArgsConstructor
public class AuthorDaoImpl implements AuthorDao {

    private final JdbcTemplate jdbcTemplate;

    @Override
    public Author findById(final Long id) {
        return jdbcTemplate.queryForObject(SELECT_AUTHOR_BY_ID, getRowMapper(), id);
    }

    @Override
    public Author findByName(final String firstName, final String lastName) {
        return jdbcTemplate.queryForObject(SELECT_AUTHOR_BY_FIRST_AND_LAST_NAME, getRowMapper(), firstName, lastName);
    }

    @Override
    public Author save(final Author author) {
        final KeyHolder keyHolder = new GeneratedKeyHolder();

        jdbcTemplate.update(connection -> {
            final PreparedStatement statement = connection.prepareStatement(INSERT_AUTHOR, Statement.RETURN_GENERATED_KEYS);
            statement.setString(1, author.getFirstName());
            statement.setString(2, author.getLastName());

            return statement;
        }, keyHolder);

        return this.findById(keyHolder.getKey().longValue());
    }

    @Override
    public Author update(final Author author) {
        jdbcTemplate.update(connection -> {
            final PreparedStatement statement = connection.prepareStatement(UPDATE_AUTHOR, Statement.RETURN_GENERATED_KEYS);
            statement.setString(1, author.getFirstName());
            statement.setString(2, author.getLastName());
            statement.setLong(3, author.getId());

            return statement;
        });

        return this.findById(author.getId());
    }

    @Override
    public boolean deleteById(final Long id) {
        final int affectedRows = jdbcTemplate.update(DELETE_AUTHOR_BY_ID, id);

        return affectedRows == 1;
    }

    private RowMapper<Author> getRowMapper() {
        return new AuthorMapper();
    }
}
