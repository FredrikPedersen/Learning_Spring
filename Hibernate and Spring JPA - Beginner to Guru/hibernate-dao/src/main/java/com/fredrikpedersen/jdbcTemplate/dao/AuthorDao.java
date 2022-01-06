package com.fredrikpedersen.jdbcTemplate.dao;

import com.fredrikpedersen.jdbcTemplate.domain.Author;

public interface AuthorDao {

    Author findById(Long id);

    Author findByName(String firstName, String lastName);

    Author save(Author author);

    Author update(Author author);

    void deleteById(Long id);
}
