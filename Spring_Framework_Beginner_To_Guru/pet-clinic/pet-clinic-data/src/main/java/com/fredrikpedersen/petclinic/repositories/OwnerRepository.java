package com.fredrikpedersen.petclinic.repositories;

import com.fredrikpedersen.petclinic.model.people.owners.Owner;
import org.springframework.data.repository.CrudRepository;

/**
 * @author Fredrik Pedersen
 * @version 1.0
 * @since 04.02.2020 at 14:20
 */

public interface OwnerRepository extends CrudRepository<Owner, Long> {

    Owner findByLastName(String lastname);
}
