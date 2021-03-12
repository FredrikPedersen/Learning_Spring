package com.fredrikpedersen.recipeproject.domain;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import javax.persistence.*;

/**
 * @author Fredrik Pedersen
 * @version 1.1
 * @since 11/03/2021 at 21:33
 */

@Data
@EqualsAndHashCode(exclude = {"recipe"})
@Entity
public class Notes {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne
    @ToString.Exclude
    private Recipe recipe;

    @Lob
    private String recipeNotes;

}
