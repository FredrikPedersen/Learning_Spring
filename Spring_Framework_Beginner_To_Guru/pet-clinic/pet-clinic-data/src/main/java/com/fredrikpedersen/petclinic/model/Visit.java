package com.fredrikpedersen.petclinic.model;

import com.fredrikpedersen.petclinic.model.pets.Pet;

import java.time.LocalDate;

/**
 * @author Fredrik Pedersen
 * @version 1.0
 * @since 23/01/2020 at 12:17
 */

public class Visit extends BaseEntity {

    private LocalDate date;
    private String description;
    private Pet pet;

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Pet getPet() {
        return pet;
    }

    public void setPet(Pet pet) {
        this.pet = pet;
    }
}
