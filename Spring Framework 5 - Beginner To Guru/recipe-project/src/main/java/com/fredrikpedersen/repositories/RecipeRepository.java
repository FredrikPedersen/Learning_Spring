package com.fredrikpedersen.repositories;

import com.fredrikpedersen.domain.Recipe;
import org.springframework.data.repository.CrudRepository;

public interface RecipeRepository extends CrudRepository<Recipe, String> {
}
