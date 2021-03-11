package com.fredrikpedersen.recipeproject.services;

import com.fredrikpedersen.recipeproject.commands.RecipeCommand;
import com.fredrikpedersen.recipeproject.domain.Recipe;

import java.util.Set;

/**
 * @author Fredrik Pedersen
 * @version 1.1
 * @since 11/03/2020 at 21:15
 */

public interface RecipeService {

    Set<Recipe> getRecipes();
    Recipe findById(long id);
    RecipeCommand saveRecipeCommand(RecipeCommand recipeCommand);
}
