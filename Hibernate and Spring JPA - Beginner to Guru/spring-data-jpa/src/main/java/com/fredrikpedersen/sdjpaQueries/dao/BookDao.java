package com.fredrikpedersen.sdjpaQueries.dao;

import com.fredrikpedersen.sdjpaQueries.domain.Book;

public interface BookDao {

    Book findById(Long id);

    Book findByTitle(String title);

    Book save(Book book);

    Book update(Book book);

    boolean deleteById(Long id);
}
