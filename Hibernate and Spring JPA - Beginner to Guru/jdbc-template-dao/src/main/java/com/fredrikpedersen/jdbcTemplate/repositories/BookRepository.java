package com.fredrikpedersen.jdbcTemplate.repositories;

import com.fredrikpedersen.jdbcTemplate.domain.Book;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepository extends JpaRepository<Book, Long> {
}
