package com.fredrikpedersen.recipeproject.converters;


import com.fredrikpedersen.recipeproject.commands.CategoryCommand;
import com.fredrikpedersen.recipeproject.domain.Category;
import lombok.Synchronized;
import org.springframework.core.convert.converter.Converter;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Component;

/**
 * @author Fredrik Pedersen
 * @version 1.0
 * @since 11/03/2021 at 20:57
 */

@Component
public class CategoryCommandToCategory implements Converter<CategoryCommand, Category>{

    @Synchronized
    @Nullable
    @Override
    public Category convert(CategoryCommand source) {
        if (source == null) {
            return null;
        }

        final Category category = new Category();
        category.setId(source.getId());
        category.setDescription(source.getDescription());
        return category;
    }
}
