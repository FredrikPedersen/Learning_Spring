package com.fredrikpedersen.petclinic.model.people.veterinarians;

import com.fredrikpedersen.petclinic.model.people.Person;
import lombok.*;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

/**
 * @author Fredrik Pedersen
 * @version 1.0
 * @since 15/01/2020 at 17:41
 */

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "veterinarians")
public class Veterinary extends Person {

    @ManyToMany(fetch = FetchType.EAGER) //Sets up eager loading
    @JoinTable(name = "vet_specialties", joinColumns = @JoinColumn(name = "vet_id"), inverseJoinColumns = @JoinColumn(name = "speciality_id"))
    private Set<Speciality> specialities = new HashSet<>();
}
