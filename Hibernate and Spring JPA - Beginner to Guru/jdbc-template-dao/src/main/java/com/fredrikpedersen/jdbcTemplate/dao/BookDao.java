package com.fredrikpedersen.jdbcTemplate.dao;

import com.fredrikpedersen.jdbcTemplate.domain.Book;

import java.util.List;

public interface BookDao {

    List<Book> findAll();

    List<Book> findAll(int pageSize, int offset);

    Book findById(Long id);

    Book findByTitle(String title);

    Book save(Book book);

    Book update(Book book);

    boolean deleteById(Long id);
}
