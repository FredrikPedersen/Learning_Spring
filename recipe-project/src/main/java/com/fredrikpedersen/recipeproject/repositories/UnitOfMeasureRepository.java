package com.fredrikpedersen.recipeproject.repositories;

import com.fredrikpedersen.recipeproject.domain.UnitOfMeasure;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

/**
 * @author Fredrik Pedersen
 * @version 1.0
 * @since 23/01/2020 at 17:51
 */

public interface UnitOfMeasureRepository extends CrudRepository<UnitOfMeasure, Long> {

    Optional<UnitOfMeasure> findByDescription(String description);
}
