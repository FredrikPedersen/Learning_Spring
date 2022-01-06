package com.fredrikpedersen.jdbcTemplate.repositories;

import com.fredrikpedersen.jdbcTemplate.domain.Author;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AuthorRepository extends JpaRepository<Author, Long> {
}
