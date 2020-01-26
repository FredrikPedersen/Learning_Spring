package com.fredrikpedersen.recipeproject.services;

import com.fredrikpedersen.recipeproject.domain.Recipe;
import com.fredrikpedersen.recipeproject.repositories.RecipeRepository;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

/**
 * @author Fredrik Pedersen
 * @version 1.0
 * @since 26/01/2020 at 16:21
 */

@Service
public class RecipeServiceImpl implements RecipeService {

    private  final RecipeRepository recipeRepository;

    public RecipeServiceImpl(RecipeRepository recipeRepository) {
        this.recipeRepository = recipeRepository;
    }

    @Override
    public Set<Recipe> getRecipes() {
        Set<Recipe> recipeSet = new HashSet<>();
        recipeRepository.findAll().iterator().forEachRemaining(recipeSet::add);
        return recipeSet;
    }
}
