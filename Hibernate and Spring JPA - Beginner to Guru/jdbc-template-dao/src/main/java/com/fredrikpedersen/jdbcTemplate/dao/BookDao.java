package com.fredrikpedersen.jdbcTemplate.dao;

import com.fredrikpedersen.jdbcTemplate.domain.Book;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface BookDao {

    List<Book> findAll();

    List<Book> findAll(int pageSize, int offset);

    List<Book> findAll(Pageable pageable);

    List<Book> findAllSortByTitle(Pageable pageable);

    Book findById(Long id);

    Book findByTitle(String title);

    Book save(Book book);

    Book update(Book book);

    boolean deleteById(Long id);
}
