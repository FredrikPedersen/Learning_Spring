package com.fredrikpedersen.petclinic.model.people.owners;

import com.fredrikpedersen.petclinic.model.people.Person;
import com.fredrikpedersen.petclinic.model.pets.Pet;
import lombok.*;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

/**
 * @author Fredrik Pedersen
 * @version 1.1
 * @since 12/04/2020 at 09:26
 */

@Setter
@Getter
@NoArgsConstructor
@Entity
@Table(name = "owners")
public class Owner extends Person {

    @Column(name = "address")
    private String address;

    @Column(name = "city")
    private String city;

    @Column(name = "telephone")
    private String telephone;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "owner") //Cascades the pets set to the owner. I.e, owner gets deleted, pets get deleted.
    private Set<Pet> pets = new HashSet<>();

    @Builder
    public Owner(Long id, String firstName, String lastName, String address, String city, String telephone,
                 Set<Pet> pets) {
        super(id, firstName, lastName);
        this.address = address;
        this.city = city;
        this.telephone = telephone;

        if (pets != null) {
            this.pets = pets;
        }
    }

    public Pet getPet(final String name) {
        return getPet(name, false);
    }

    public Pet getPet(final String name, final boolean ignoreNew) {
        for (Pet pet: pets) {
            if (!ignoreNew || !pet.isNew()) {
                final String compareName = pet.getName().toLowerCase();
                if (compareName.equals(name.toLowerCase())) {
                    return pet;
                }

            }
        }
        return null;
    }


}
