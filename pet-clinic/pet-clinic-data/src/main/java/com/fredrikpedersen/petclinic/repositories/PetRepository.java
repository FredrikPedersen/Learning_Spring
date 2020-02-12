package com.fredrikpedersen.petclinic.repositories;

import com.fredrikpedersen.petclinic.model.pets.Pet;
import org.springframework.data.repository.CrudRepository;

/**
 * @author Fredrik Pedersen
 * @version 1.0
 * @since 04.02.2020 at 14:21
 */

public interface PetRepository extends CrudRepository<Pet, Long> {
}
