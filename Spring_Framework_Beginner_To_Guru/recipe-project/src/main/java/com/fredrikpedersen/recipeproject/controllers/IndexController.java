package com.fredrikpedersen.recipeproject.controllers;

import com.fredrikpedersen.recipeproject.services.RecipeService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author Fredrik Pedersen
 * @version 1.0
 * @since 22/01/2020 at 11:58
 */

@Controller
public class IndexController {
    private final String INDEX_VIEW = "index";

    private final RecipeService recipeService;

    public IndexController(RecipeService recipeService) {
        this.recipeService = recipeService;
    }

    @RequestMapping({"", "/", INDEX_VIEW})
    public String getIndexPage(Model model) {

        model.addAttribute("recipes", recipeService.getRecipes());

        return INDEX_VIEW;
    }
}
