package com.fredrikpedersen.repositories.reactive;

import com.fredrikpedersen.domain.UnitOfMeasure;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

/**
 * @author Fredrik Pedersen
 * @version 1.0
 * @since 13/07/2021 at 17:56
 */

public interface UnitOfMeasureReactiveRepository extends ReactiveMongoRepository<UnitOfMeasure, String> {
}
