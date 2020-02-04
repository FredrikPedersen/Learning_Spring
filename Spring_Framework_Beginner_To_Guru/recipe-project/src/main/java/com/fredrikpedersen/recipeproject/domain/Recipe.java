package com.fredrikpedersen.recipeproject.domain;

import lombok.Data;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

/**
 * @author Fredrik Pedersen
 * @version 1.0
 * @since 23/01/2020 at 16:08
 */

@Data
@Entity
public class Recipe {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String description;
    private Integer prepTime;
    private Integer cookTime;
    private Integer servings;
    private String source;
    private String url;

    @Lob
    private String directions;

    //mappedBy links the ingredients to this object by it recipe attribute
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "recipe")
    private Set<Ingredient> ingredients = new HashSet<>();

    @Lob
    private Byte[] image;

    //EnumType Ordinal is default. Ordinal saves the Enum values as numbers, i.e in our case EASY = 1, MODERATE = 2. If we add a VERY_EASY before EASY, then VERY_EASY = 1, EASY = 2
    //EnymType String saves the Enum values as their String values.
    @Enumerated(value = EnumType.STRING)
    private Difficulty difficulty;

    @OneToOne(cascade = CascadeType.ALL) //If we delete a Recipe, it's belonging notes are deleted.
    private Notes notes;

    @ManyToMany
    @JoinTable(name = "recipe_category", joinColumns = @JoinColumn(name = "recipe_id"),
                inverseJoinColumns = @JoinColumn(name = "category_id"))
    private Set<Category> categories = new HashSet<>();

    public void setNotes(Notes notes) {
        this.notes = notes;
        notes.setRecipe(this);
    }

    public Recipe addIngredient(Ingredient ingredient) {
        ingredient.setRecipe(this);
        this.ingredients.add(ingredient);
        return this;
    }
}
