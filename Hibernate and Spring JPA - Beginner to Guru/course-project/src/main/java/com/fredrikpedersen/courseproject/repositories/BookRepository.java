package com.fredrikpedersen.courseproject.repositories;

import com.fredrikpedersen.courseproject.domain.Book;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepository extends JpaRepository<Book, Long> {
}
