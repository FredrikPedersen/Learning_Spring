package com.fredrikpedersen.recipeproject.controllers;

import com.fredrikpedersen.recipeproject.commands.RecipeCommand;
import com.fredrikpedersen.recipeproject.services.RecipeService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

/**
 * @author Fredrik Pedersen
 * @version 1.1
 * @since 12/03/2021 at 09:50
 */

@RequiredArgsConstructor
@Controller
public class RecipeController {

    private final RecipeService recipeService;

    @GetMapping
    @RequestMapping("/recipe/show/{id}")
    public String showById(@PathVariable final String id, final Model model) {
        model.addAttribute("recipe", recipeService.findById(Long.parseLong(id)));
        return "recipe/show";
    }

    @GetMapping
    @RequestMapping("recipe/new")
    public String newRecipe(final Model model) {
        model.addAttribute("recipe", new RecipeCommand());

        return "recipe/recipeForm";
    }

    @GetMapping
    @RequestMapping("recipe/{id}/update")
    public String updateRecipe(@PathVariable final String id, final Model model) {
        model.addAttribute("recipe", recipeService.findCommandById(Long.valueOf(id)));
        return "recipe/recipeForm";
    }

    @PostMapping
    @RequestMapping("recipe")
    public String saveOrUpdate(@ModelAttribute final RecipeCommand recipeCommand) {
        final RecipeCommand savedCommand = recipeService.saveRecipeCommand(recipeCommand);
        return "redirect:/recipe/" + savedCommand.getId() + "/show";
    }

    @GetMapping
    @RequestMapping("recipe/{id}/delete")
    public String deleteById(@PathVariable final String id) {
        recipeService.deleteById(Long.valueOf(id));
        return "redirect:/";
    }
}
