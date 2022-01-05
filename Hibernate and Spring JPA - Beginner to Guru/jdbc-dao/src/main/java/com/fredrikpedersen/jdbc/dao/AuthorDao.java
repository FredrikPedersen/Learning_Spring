package com.fredrikpedersen.jdbc.dao;

import com.fredrikpedersen.jdbc.domain.Author;

public interface AuthorDao {

    Author findById(Long id);

    Author findByName(String firstName, String lastName);

    Author save(Author author);

    Author update(Author author);

    boolean deleteById(Long id);
}
