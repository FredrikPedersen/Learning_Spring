package com.fredrikpedersen.recipeproject.repositories;

import com.fredrikpedersen.recipeproject.domain.Category;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

/**
 * @author Fredrik Pedersen
 * @version 1.0
 * @since 23/01/2020 at 17:51
 */

public interface CategoryRepository extends CrudRepository<Category, Long> {

    Optional<Category> findByDescription(String decription);
}
