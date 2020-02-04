package com.fredrikpedersen.recipeproject.domain;

import lombok.Data;

import javax.persistence.*;

/**
 * @author Fredrik Pedersen
 * @version 1.0
 * @since 23/01/2020 at 16:08
 */

@Data
@Entity
public class Notes {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne
    private Recipe recipe;

    @Lob
    private String recipeNote;
}
