package com.fredrikpedersen.recipeproject.repositories;

import com.fredrikpedersen.recipeproject.domain.Category;
import org.springframework.data.repository.CrudRepository;

/**
 * @author Fredrik Pedersen
 * @version 1.0
 * @since 23/01/2020 at 17:51
 */

public interface CategoryRepository extends CrudRepository<Category, Long> {

}
