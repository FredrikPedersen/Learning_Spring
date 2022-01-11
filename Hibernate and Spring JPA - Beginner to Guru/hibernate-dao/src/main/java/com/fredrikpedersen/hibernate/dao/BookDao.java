package com.fredrikpedersen.hibernate.dao;

import com.fredrikpedersen.hibernate.domain.Book;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface BookDao {

    List<Book> findAll();

    List<Book> findAll(int pageSize, int offset);

    List<Book> findAll(Pageable pageable);

    List<Book> findAllSortByTitle(Pageable pageable);

    Book findByISBN(String isbn);

    Book findById(Long id);

    Book findByTitle(String title);

    Book save(Book book);

    Book update(Book book);

    void deleteById(Long id);
}
