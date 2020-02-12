package com.fredrikpedersen.petclinic.repositories;

import com.fredrikpedersen.petclinic.model.Visit;
import org.springframework.data.repository.CrudRepository;

/**
 * @author Fredrik Pedersen
 * @version 1.0
 * @since 04.02.2020 at 14:24
 */

public interface VisitRepository extends CrudRepository<Visit, Long> {
}
