package com.fredrikpedersen.hibernate.dao;

import com.fredrikpedersen.hibernate.domain.Author;

import java.util.List;

public interface AuthorDao {

    List<Author> findAll();

    List<Author> findAllWithLastNameLike(String lastName);

    Author findById(Long id);

    Author findByName(String firstName, String lastName);

    Author findByNameNative(String firstName, String lastName);

    Author save(Author author);

    Author update(Author author);

    void deleteById(Long id);
}
