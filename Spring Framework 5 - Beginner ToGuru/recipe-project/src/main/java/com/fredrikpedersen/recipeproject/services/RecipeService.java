package com.fredrikpedersen.recipeproject.services;

import com.fredrikpedersen.recipeproject.commands.RecipeCommand;
import com.fredrikpedersen.recipeproject.domain.Recipe;

import java.util.Set;


public interface RecipeService {

    Set<Recipe> getRecipes();

    Recipe findById(Long l);

    RecipeCommand findCommandById(Long l);

    RecipeCommand saveRecipeCommand(RecipeCommand command);

    void deleteById(Long idToDelete);
}
