package com.fredrikpedersen.springmvcrest.api.v1.mapper;

import com.fredrikpedersen.springmvcrest.api.v1.model.category.CategoryDTO;
import com.fredrikpedersen.springmvcrest.domain.Category;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author Fredrik Pedersen
 * @version 1.0
 * @since 16/02/2020 at 17:02
 */

class CategoryMapperTest {

    private static final String NAME = "Joe";
    private static final long ID = 1L;

    CategoryMapper categoryMapper = CategoryMapper.INSTANCE;

    @Test
    void categoryToCategoryDTO() {

        //given
        Category category = new Category();
        category.setName(NAME);
        category.setId(ID);

        //when
        CategoryDTO categoryDTO = categoryMapper.categoryToCategoryDTO(category);

        //then
        assertEquals(Long.valueOf(ID), categoryDTO.getId());
        assertEquals(NAME, categoryDTO.getName());
    }
}