package com.fredrikpedersen.recipeproject.controllers;

import com.fredrikpedersen.recipeproject.domain.Category;
import com.fredrikpedersen.recipeproject.domain.UnitOfMeasure;
import com.fredrikpedersen.recipeproject.repositories.CategoryRepository;
import com.fredrikpedersen.recipeproject.repositories.UnitOfMeasureRepository;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Optional;

/**
 * @author Fredrik Pedersen
 * @version 1.0
 * @since 22/01/2020 at 11:58
 */

@Controller
public class IndexController {

    private CategoryRepository categoryRepository;
    private UnitOfMeasureRepository unitOfMeasureRepository;

    public IndexController(CategoryRepository categoryRepository, UnitOfMeasureRepository unitOfMeasureRepository) {
        this.categoryRepository = categoryRepository;
        this.unitOfMeasureRepository = unitOfMeasureRepository;
    }

    private final String INDEX_VIEW = "index";

    @RequestMapping({"", "/", INDEX_VIEW})
    public String getIndexPage() {

        Optional<Category> categoryOptional = categoryRepository.findByDescription("American");
        Optional<UnitOfMeasure> unitOfMeasureOptional = unitOfMeasureRepository.findByDescription("Liter");

        System.out.println("Cat Id is: " + categoryOptional.get().getId());
        System.out.println("Uom Id is: " + unitOfMeasureOptional.get().getId());

        return INDEX_VIEW;
    }
}
