package com.fredrikpedersen.recipeproject.domain;

import lombok.*;

import javax.persistence.*;
import java.util.Set;

/**
 * @author Fredrik Pedersen
 * @version 1.0
 * @since 23/01/2020 at 16:47
 */

@Data
@EqualsAndHashCode(exclude = {"recipes"}) //Excludes the attributes from the Equals and Hashcode methods.
@Entity
public class Category {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String description;

    @ManyToMany(mappedBy = "categories")
    @ToString.Exclude
    private Set<Recipe> recipes;

}
