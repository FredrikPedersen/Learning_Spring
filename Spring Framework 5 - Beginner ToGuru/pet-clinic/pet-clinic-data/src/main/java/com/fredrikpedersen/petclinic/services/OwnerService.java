package com.fredrikpedersen.petclinic.services;

import com.fredrikpedersen.petclinic.model.people.owners.Owner;

import java.util.List;

/**
 * @author Fredrik Pedersen
 * @version 1.1
 * @since 31.03.2021 at 10:32
 */

public interface OwnerService extends CrudService<Owner, Long>{

    Owner findByLastName(String lastName);

    List<Owner> findAllByLastNameLike(String lastname);
}

