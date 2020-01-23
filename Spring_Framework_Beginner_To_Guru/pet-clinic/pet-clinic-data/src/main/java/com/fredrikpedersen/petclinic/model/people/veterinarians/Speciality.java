package com.fredrikpedersen.petclinic.model.people.veterinarians;

import com.fredrikpedersen.petclinic.model.BaseEntity;

/**
 * @author Fredrik Pedersen
 * @version 1.0
 * @since 23/01/2020 at 12:22
 */
public class Speciality extends BaseEntity {

    private String description;

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
