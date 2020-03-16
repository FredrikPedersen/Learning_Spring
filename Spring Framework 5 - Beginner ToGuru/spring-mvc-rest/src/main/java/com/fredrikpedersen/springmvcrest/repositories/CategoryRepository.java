package com.fredrikpedersen.springmvcrest.repositories;

import com.fredrikpedersen.springmvcrest.domain.Category;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author Fredrik Pedersen
 * @version 1.0
 * @since 16/02/2020 at 16:26
 */


public interface CategoryRepository extends JpaRepository<Category, Long> {
    Category findByName(final String name);
}
