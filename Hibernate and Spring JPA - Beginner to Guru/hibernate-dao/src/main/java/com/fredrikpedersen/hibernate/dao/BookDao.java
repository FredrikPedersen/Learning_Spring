package com.fredrikpedersen.hibernate.dao;

import com.fredrikpedersen.hibernate.domain.Book;

import java.util.List;

public interface BookDao {

    List<Book> findAll();

    Book findByISBN(String isbn);

    Book findById(Long id);

    Book findByTitle(String title);

    Book save(Book book);

    Book update(Book book);

    void deleteById(Long id);
}
