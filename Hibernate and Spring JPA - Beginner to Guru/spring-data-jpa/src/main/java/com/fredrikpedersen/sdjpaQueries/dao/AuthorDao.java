package com.fredrikpedersen.sdjpaQueries.dao;

import com.fredrikpedersen.sdjpaQueries.domain.Author;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface AuthorDao {

    List<Author> findAllByLastName(String lastname, Pageable pageable);

    Author findById(Long id);

    Author findByName(String firstName, String lastName);

    Author save(Author author);

    Author update(Author author);

    void deleteById(Long id);
}
