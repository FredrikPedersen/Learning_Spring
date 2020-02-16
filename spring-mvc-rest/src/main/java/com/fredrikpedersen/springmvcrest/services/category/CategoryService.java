package com.fredrikpedersen.springmvcrest.services.category;

import com.fredrikpedersen.springmvcrest.api.v1.model.category.CategoryDTO;

import java.util.List;

/**
 * @author Fredrik Pedersen
 * @version 1.0
 * @since 16/02/2020 at 17:13
 */

public interface CategoryService {

    List<CategoryDTO> getAllCategories();
    CategoryDTO getCategoryByName(final String name);
}
