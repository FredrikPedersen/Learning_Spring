package com.fredrikpedersen.petclinic.model.people.veterinaries;

import com.fredrikpedersen.petclinic.model.people.Person;

import java.util.Set;

/**
 * @author Fredrik Pedersen
 * @version 1.0
 * @since 15/01/2020 at 17:41
 */

public class Veterinary extends Person {

    private Set<Speciality> specialities;

    public Set<Speciality> getSpecialities() {
        return specialities;
    }

    public void setSpecialities(Set<Speciality> specialities) {
        this.specialities = specialities;
    }
}
