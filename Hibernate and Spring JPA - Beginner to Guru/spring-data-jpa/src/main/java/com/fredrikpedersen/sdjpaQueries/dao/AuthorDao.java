package com.fredrikpedersen.sdjpaQueries.dao;

import com.fredrikpedersen.sdjpaQueries.domain.Author;

public interface AuthorDao {

    Author findById(Long id);

    Author findByName(String firstName, String lastName);

    Author save(Author author);

    Author update(Author author);

    boolean deleteById(Long id);
}
