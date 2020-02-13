package com.fredrikpedersen.recipeproject.domain;

import lombok.Data;

import javax.persistence.*;

/**
 * @author Fredrik Pedersen
 * @version 1.5
 * @since 23/01/2020 at 16:39
 */

@Data
@Entity
public class UnitOfMeasure {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String description;
}
