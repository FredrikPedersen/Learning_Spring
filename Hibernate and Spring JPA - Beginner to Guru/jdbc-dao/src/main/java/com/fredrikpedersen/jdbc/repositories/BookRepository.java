package com.fredrikpedersen.jdbc.repositories;

import com.fredrikpedersen.jdbc.domain.Book;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepository extends JpaRepository<Book, Long> {
}
