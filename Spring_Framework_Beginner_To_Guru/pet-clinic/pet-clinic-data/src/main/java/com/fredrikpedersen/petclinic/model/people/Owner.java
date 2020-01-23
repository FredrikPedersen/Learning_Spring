package com.fredrikpedersen.petclinic.model.people;

import com.fredrikpedersen.petclinic.model.pets.Pet;

import java.util.Set;

/**
 * @author Fredrik Pedersen
 * @version 1.0
 * @since 15/01/2020 at 17:41
 */

public class Owner extends Person {

    private Set<Pet> pets;

    public Set<Pet> getPets() {
        return pets;
    }

    public void setPets(Set<Pet> pets) {
        this.pets = pets;
    }
}
