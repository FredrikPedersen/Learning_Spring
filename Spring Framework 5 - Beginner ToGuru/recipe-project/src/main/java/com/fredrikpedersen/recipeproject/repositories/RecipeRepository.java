package com.fredrikpedersen.recipeproject.repositories;

import com.fredrikpedersen.recipeproject.domain.Recipe;
import org.springframework.data.repository.CrudRepository;


public interface RecipeRepository extends CrudRepository<Recipe, Long> {
}
