package com.fredrikpedersen.recipeproject.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author Fredrik Pedersen
 * @version 1.0
 * @since 22/01/2020 at 11:58
 */

@Controller
public class IndexController {

    private final String INDEX_VIEW = "index";

    @RequestMapping({"", "/", INDEX_VIEW})
    public String getIndexPage() {
        System.out.println("Hello there");
        return INDEX_VIEW;
    }
}
