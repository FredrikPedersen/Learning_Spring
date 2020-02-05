package com.fredrikpedersen.petclinic.model;

import com.fredrikpedersen.petclinic.model.pets.Pet;
import lombok.*;

import javax.persistence.*;
import java.time.LocalDate;

/**
 * @author Fredrik Pedersen
 * @version 1.0
 * @since 23/01/2020 at 12:17
 */

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "visits")
public class Visit extends BaseEntity {

    @Column(name = "date")
    private LocalDate date;

    @Column(name = "description")
    private String description;

    @ManyToOne
    @JoinColumn(name = "pet_id")
    private Pet pet;
}
