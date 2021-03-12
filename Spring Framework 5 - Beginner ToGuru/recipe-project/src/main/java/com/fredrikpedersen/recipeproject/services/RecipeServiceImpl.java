package com.fredrikpedersen.recipeproject.services;

import com.fredrikpedersen.recipeproject.commands.RecipeCommand;
import com.fredrikpedersen.recipeproject.converters.RecipeCommandToRecipe;
import com.fredrikpedersen.recipeproject.converters.RecipeToRecipeCommand;
import com.fredrikpedersen.recipeproject.domain.Recipe;
import com.fredrikpedersen.recipeproject.repositories.RecipeRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

/**
 * @author Fredrik Pedersen
 * @version 1.3
 * @since 12/03/2021 at 10:41
 */

@Slf4j
@Service
@RequiredArgsConstructor
public class RecipeServiceImpl implements RecipeService {

    private final RecipeRepository recipeRepository;
    private final RecipeCommandToRecipe recipeCommandToRecipe;
    private final RecipeToRecipeCommand recipeToRecipeCommand;

    @Override
    public Set<Recipe> getRecipes() {
        final Set<Recipe> recipeSet = new HashSet<>();
        recipeRepository.findAll().iterator().forEachRemaining(recipeSet::add);
        return recipeSet;
    }

    @Override
    public Recipe findById(final Long id) {
        return recipeRepository.findById(id).orElseThrow(() -> new RuntimeException("Recipe Not Found!"));
    }

    @Override
    @Transactional
    public RecipeCommand findCommandById(Long id) {
        return recipeToRecipeCommand.convert(findById(id));
    }

    @Override
    @Transactional
    public RecipeCommand saveRecipeCommand(final RecipeCommand recipeCommand) {
        final Recipe recipeFromCommand = recipeCommandToRecipe.convert(recipeCommand);
        return recipeToRecipeCommand.convert(recipeRepository.save(recipeFromCommand));
    }

    @Override
    public void deleteById(final Long id) {
        recipeRepository.deleteById(id);
    }
}
