package com.fredrikpedersen.springmvcrest.api.v1.mapper;

import com.fredrikpedersen.springmvcrest.api.v1.model.CategoryDTO;
import com.fredrikpedersen.springmvcrest.domain.Category;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

/**
 * @author Fredrik Pedersen
 * @version 1.0
 * @since 16/02/2020 at 16:53
 */

@Mapper
public interface CategoryMapper {

    CategoryMapper INSTANCE = Mappers.getMapper(CategoryMapper.class);

    CategoryDTO categoryToCategoryDTO(Category category);
}
