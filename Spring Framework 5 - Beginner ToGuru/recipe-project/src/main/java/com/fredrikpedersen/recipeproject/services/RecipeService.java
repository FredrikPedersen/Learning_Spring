package com.fredrikpedersen.recipeproject.services;

import com.fredrikpedersen.recipeproject.domain.Recipe;

import java.util.Set;

/**
 * @author Fredrik Pedersen
 * @version 1.0
 * @since 26/01/2020 at 16:21
 */

public interface RecipeService {

    Set<Recipe> getRecipes();
}
