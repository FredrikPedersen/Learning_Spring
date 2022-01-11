package com.fredrikpedersen.sdjpaQueries.dao;

import com.fredrikpedersen.sdjpaQueries.domain.Book;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface BookDao {

    List<Book> findAll();

    List<Book> findAll(Pageable pageable);

    List<Book> findAll(int pageSize, int offset);

    List<Book> findAllSortByTitle(Pageable pageable);

    Book findById(Long id);

    Book findByTitle(String title);

    Book save(Book book);

    Book update(Book book);

    void deleteById(Long id);
}
