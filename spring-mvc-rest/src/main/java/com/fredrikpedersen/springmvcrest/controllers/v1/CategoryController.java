package com.fredrikpedersen.springmvcrest.controllers.v1;

import com.fredrikpedersen.springmvcrest.api.v1.model.category.CategoryDTO;
import com.fredrikpedersen.springmvcrest.api.v1.model.category.CategoryListDTO;
import com.fredrikpedersen.springmvcrest.services.category.CategoryService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author Fredrik Pedersen
 * @version 1.0
 * @since 16/02/2020 at 17:27
 */

@Controller
@RequestMapping(CategoryController.BASE_URL)
public class CategoryController {

    public final static String BASE_URL = "/api/v1/categories/";
    private final CategoryService categoryService;

    public CategoryController(final CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @GetMapping
    public ResponseEntity<CategoryListDTO> getAllCategories() {
        return new ResponseEntity<>(new CategoryListDTO(categoryService.getAllCategories()), HttpStatus.OK);
    }

    @GetMapping("{name}")
    public ResponseEntity<CategoryDTO> getCategoryByName(@PathVariable final String name) {
        return new ResponseEntity<>(
                categoryService.getCategoryByName(name), HttpStatus.OK
        );
    }
}
