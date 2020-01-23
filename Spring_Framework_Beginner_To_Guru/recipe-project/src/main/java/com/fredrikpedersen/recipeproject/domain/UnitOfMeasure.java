package com.fredrikpedersen.recipeproject.domain;

import javax.persistence.*;

/**
 * @author Fredrik Pedersen
 * @version 1.5
 * @since 23/01/2020 at 16:39
 */

@Entity
public class UnitOfMeasure {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String description;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String uom) {
        this.description = uom;
    }
}
