package com.fredrikpedersen.services;

import com.fredrikpedersen.commands.RecipeCommand;
import com.fredrikpedersen.converters.RecipeCommandToRecipe;
import com.fredrikpedersen.converters.RecipeToRecipeCommand;
import com.fredrikpedersen.domain.Recipe;
import com.fredrikpedersen.repositories.reactive.RecipeReactiveRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Slf4j
@Service
@RequiredArgsConstructor
public class RecipeServiceImpl implements RecipeService {

    private final RecipeReactiveRepository recipeRepository;
    private final RecipeCommandToRecipe recipeCommandToRecipe;
    private final RecipeToRecipeCommand recipeToRecipeCommand;

    @Override
    public Flux<Recipe> getRecipes() {
        return recipeRepository.findAll();
    }

    @Override
    public Mono<Recipe> findById(final String id) {
        return recipeRepository.findById(id);
    }

    @Override
    public Mono<RecipeCommand> findCommandById(final String id) {
        return recipeRepository.findById(id)
                .map(recipe -> {
                    final RecipeCommand recipeCommand = recipeToRecipeCommand.convert(recipe);
                    recipeCommand.getIngredients().forEach(rc -> rc.setRecipeId(recipeCommand.getId()));

                    return recipeCommand;
                });
    }

    @Override
    public Mono<RecipeCommand> saveRecipeCommand(final RecipeCommand command) {
        return recipeRepository
                .save(recipeCommandToRecipe.convert(command))
                .map(recipeToRecipeCommand::convert);
    }

    @Override
    public Mono<Void> deleteById(String idToDelete) {
        recipeRepository.deleteById(idToDelete).block();
        return Mono.empty();
    }
}
