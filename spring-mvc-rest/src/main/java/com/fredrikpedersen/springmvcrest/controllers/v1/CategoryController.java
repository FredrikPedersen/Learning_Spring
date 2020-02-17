package com.fredrikpedersen.springmvcrest.controllers.v1;

import com.fredrikpedersen.springmvcrest.api.v1.model.category.CategoryDTO;
import com.fredrikpedersen.springmvcrest.api.v1.model.category.CategoryListDTO;
import com.fredrikpedersen.springmvcrest.services.category.CategoryService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

/**
 * @author Fredrik Pedersen
 * @version 1.0
 * @since 16/02/2020 at 17:27
 */

@RestController
@RequestMapping(CategoryController.BASE_URL)
public class CategoryController {

    public final static String BASE_URL = "/api/v1/categories/";
    private final CategoryService categoryService;

    public CategoryController(final CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public CategoryListDTO getAllCategories() {
        return new CategoryListDTO(categoryService.getAllCategories());
    }

    @GetMapping("{name}")
    @ResponseStatus(HttpStatus.OK)
    public CategoryDTO getCategoryByName(@PathVariable final String name) {
        return categoryService.getCategoryByName(name);
    }
}
