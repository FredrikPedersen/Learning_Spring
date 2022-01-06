package com.fredrikpedersen.hibernate.dao;

import com.fredrikpedersen.hibernate.domain.Author;

public interface AuthorDao {

    Author findById(Long id);

    Author findByName(String firstName, String lastName);

    Author save(Author author);

    Author update(Author author);

    void deleteById(Long id);
}
