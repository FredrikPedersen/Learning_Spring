package com.fredrikpedersen.webfluxrest.repository;

import com.fredrikpedersen.webfluxrest.domain.Category;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;

/**
 * @author Fredrik Pedersen
 * @version 1.0
 * @since 15/07/2021 at 17:04
 */

@Repository
public interface CategoryRepository extends ReactiveMongoRepository<Category, String> {
}
