package com.fredrikpedersen.recipeproject.services;

import com.fredrikpedersen.recipeproject.commands.RecipeCommand;
import com.fredrikpedersen.recipeproject.domain.Recipe;

import java.util.Set;

/**
 * @author Fredrik Pedersen
 * @version 1.1
 * @since 12/03/2020 at 10:42
 */

public interface RecipeService {

    Set<Recipe> getRecipes();
    Recipe findById(Long id);
    void deleteById(Long id);
    RecipeCommand findCommandById(Long id);
    RecipeCommand saveRecipeCommand(RecipeCommand recipeCommand);
}
