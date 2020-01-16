package com.fredrikpedersen.petclinic.model.pets;

import com.fredrikpedersen.petclinic.model.BaseEntity;

/**
 * @author Fredrik Pedersen
 * @version 1.0
 * @since 15/01/2020 at 17:42
 */

public class PetType extends BaseEntity {

    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
