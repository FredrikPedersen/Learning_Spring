package com.fredrikpedersen.jdbc.repositories;

import com.fredrikpedersen.jdbc.domain.Author;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AuthorRepository extends JpaRepository<Author, Long> {
}
