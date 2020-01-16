package com.fredrikpedersen.petclinic.services;

import com.fredrikpedersen.petclinic.model.people.Owner;

/**
 * @author Fredrik Pedersen
 * @version 1.0
 * @since 16/01/2020 at 13:21
 */

public interface OwnerService extends CrudService<Owner, Long>{

    Owner findByLastName(String lastName);

}

