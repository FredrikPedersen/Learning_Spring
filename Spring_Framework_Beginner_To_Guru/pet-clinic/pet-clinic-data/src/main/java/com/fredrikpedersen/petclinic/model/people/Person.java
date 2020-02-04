package com.fredrikpedersen.petclinic.model.people;

import com.fredrikpedersen.petclinic.model.BaseEntity;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;

/**
 * @author Fredrik Pedersen
 * @version 1.0
 * @since 15/01/2020 at 17:40
 */

@MappedSuperclass
public abstract class Person extends BaseEntity {

    @Column(name = "first_name") //Snake casing is default for JPA
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
}
