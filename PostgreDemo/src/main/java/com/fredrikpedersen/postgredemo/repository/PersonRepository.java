package com.fredrikpedersen.postgredemo.repository;

import com.fredrikpedersen.postgredemo.model.Person;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

/**
 * @author Fredrik Pedersen
 * @version 1.0
 * @since 01/04/2020 at 13:40
 */

@RepositoryRestResource
public interface PersonRepository extends CrudRepository<Person, Long> {
}
