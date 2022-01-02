package com.fredrikpedersen.petclinic.repositories;

import com.fredrikpedersen.petclinic.model.people.owners.Owner;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

/**
 * @author Fredrik Pedersen
 * @version 1.1
 * @since 31.03.2021 at 10:32
 */

public interface OwnerRepository extends CrudRepository<Owner, Long> {

    Owner findByLastName(String lastname);

    List<Owner> findAllByLastNameLike(String lastname);
}
