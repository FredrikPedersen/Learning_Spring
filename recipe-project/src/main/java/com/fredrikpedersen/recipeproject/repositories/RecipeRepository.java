package com.fredrikpedersen.recipeproject.repositories;

import com.fredrikpedersen.recipeproject.domain.Recipe;
import org.springframework.data.repository.CrudRepository;

/**
 * @author Fredrik Pedersen
 * @version 1.0
 * @since 23/01/2020 at 17:50
 */

public interface RecipeRepository extends CrudRepository<Recipe, Long> {

}
