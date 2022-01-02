package com.fredrikpedersen.postgredemo.repositories;

import com.fredrikpedersen.postgredemo.model.Person;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * @author Fredrik Pedersen
 * @version 1.0
 * @since 01/04/2020 at 13:40
 */

@Repository
public interface PersonRepository extends CrudRepository<Person, Long> {
}
