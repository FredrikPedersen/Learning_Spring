package com.fredrikpedersen.petclinic.services;

import com.fredrikpedersen.petclinic.model.people.Veterinary;

import java.util.Set;

/**
 * @author Fredrik Pedersen
 * @version 1.0
 * @since 16/01/2020 at 13:24
 */
public interface VeterinaryService {
    Veterinary findById(Long id);
    Veterinary save(Veterinary veterinary);
    Set<Veterinary> findAll();
}
