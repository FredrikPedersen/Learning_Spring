package com.fredrikpedersen.petclinic.repositories;

import com.fredrikpedersen.petclinic.model.people.veterinarians.Veterinary;
import org.springframework.data.repository.CrudRepository;

/**
 * @author Fredrik Pedersen
 * @version 1.0
 * @since 04.02.2020 at 14:23
 */

public interface VeterinaryRepository extends CrudRepository<Veterinary, Long> {
}
