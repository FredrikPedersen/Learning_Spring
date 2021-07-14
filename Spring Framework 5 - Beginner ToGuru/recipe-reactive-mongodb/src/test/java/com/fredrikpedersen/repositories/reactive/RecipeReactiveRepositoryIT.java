package com.fredrikpedersen.repositories.reactive;

import com.fredrikpedersen.domain.Recipe;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.data.mongo.DataMongoTest;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author Fredrik Pedersen
 * @version 1.0
 * @since 14/07/2021 at 09:42
 */

@DataMongoTest
class RecipeReactiveRepositoryIT {

    @Autowired
    RecipeReactiveRepository recipeReactiveRepository;

    @BeforeEach
    public void setUp() {
        recipeReactiveRepository.deleteAll().block();
    }

    @Test
    public void testRecipeSave() {
        final Recipe recipe = new Recipe();
        recipe.setDescription("Yummy");

        recipeReactiveRepository.save(recipe).block();

        final Long count = recipeReactiveRepository.count().block();

        assertEquals(Long.valueOf(1L), count);
    }

}