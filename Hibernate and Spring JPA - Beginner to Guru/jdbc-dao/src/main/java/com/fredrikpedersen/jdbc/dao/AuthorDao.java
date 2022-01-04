package com.fredrikpedersen.jdbc.dao;

import com.fredrikpedersen.jdbc.domain.Author;

public interface AuthorDao {

    Author getById(Long id);
    Author getByName(String firstName, String lastName);
}
