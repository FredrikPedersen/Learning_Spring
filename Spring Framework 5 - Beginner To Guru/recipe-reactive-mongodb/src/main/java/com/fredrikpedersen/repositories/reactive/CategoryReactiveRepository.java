package com.fredrikpedersen.repositories.reactive;

import com.fredrikpedersen.domain.Category;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import reactor.core.publisher.Mono;

/**
 * @author Fredrik Pedersen
 * @version 1.0
 * @since 14/07/2021 at 09:37
 */
public interface CategoryReactiveRepository extends ReactiveMongoRepository<Category, String> {

    Mono<Category> findByDescription(String description);
}
