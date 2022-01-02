package com.fredrikpedersen.repositories.reactive;

import com.fredrikpedersen.domain.Recipe;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

/**
 * @author Fredrik Pedersen
 * @version 1.0
 * @since 14/07/2021 at 09:37
 */
public interface RecipeReactiveRepository extends ReactiveMongoRepository<Recipe, String> {
}
