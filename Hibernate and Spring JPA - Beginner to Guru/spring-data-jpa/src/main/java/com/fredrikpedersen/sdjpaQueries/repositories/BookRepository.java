package com.fredrikpedersen.sdjpaQueries.repositories;

import com.fredrikpedersen.sdjpaQueries.domain.Book;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepository extends JpaRepository<Book, Long> {
}
