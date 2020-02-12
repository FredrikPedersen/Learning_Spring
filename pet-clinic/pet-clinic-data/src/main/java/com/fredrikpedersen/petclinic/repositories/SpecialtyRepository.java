package com.fredrikpedersen.petclinic.repositories;

import com.fredrikpedersen.petclinic.model.people.veterinarians.Speciality;
import org.springframework.data.repository.CrudRepository;

/**
 * @author Fredrik Pedersen
 * @version 1.0
 * @since 04.02.2020 at 14:22
 */
public interface SpecialtyRepository extends CrudRepository<Speciality, Long> {
}
