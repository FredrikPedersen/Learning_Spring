package com.fredrikpedersen.petclinic.model.pets;

import com.fredrikpedersen.petclinic.model.BaseEntity;
import com.fredrikpedersen.petclinic.model.people.owners.Owner;

import java.time.LocalDate;

/**
 * @author Fredrik Pedersen
 * @version 1.0
 * @since 15/01/2020 at 17:42
 */
public class Pet extends BaseEntity {

    private PetType petType;
    private Owner owner;
    private LocalDate birthDate;

    public PetType getPetType() {
        return petType;
    }

    public void setPetType(PetType petType) {
        this.petType = petType;
    }

    public Owner getOwner() {
        return owner;
    }

    public void setOwner(Owner owner) {
        this.owner = owner;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
    }
}
