package com.fredrikpedersen.recipeproject.commands;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * @author Fredrik Pedersen
 * @version 1.0
 * @since 11/03/2021 at 20:56
 */

@Setter
@Getter
@NoArgsConstructor
public class CategoryCommand {
    private Long id;
    private String description;
}
