package com.fredrikpedersen.petclinic.services;

import com.fredrikpedersen.petclinic.model.pets.Pet;

import java.util.Set;

/**
 * @author Fredrik Pedersen
 * @version 1.0
 * @since 16/01/2020 at 13:23
 */

public interface PetService {
    Pet findById(Long id);
    Pet save(Pet pet);
    Set<Pet> findAll();
}
