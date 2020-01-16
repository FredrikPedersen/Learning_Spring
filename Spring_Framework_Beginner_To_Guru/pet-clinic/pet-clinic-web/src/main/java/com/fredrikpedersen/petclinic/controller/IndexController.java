package com.fredrikpedersen.petclinic.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author Fredrik Pedersen
 * @version 1.0
 * @since 16/01/2020 at 18:22
 */

@Controller
public class IndexController {

    private static final String INDEX_VIEW = "index";

    @RequestMapping({"/", "", INDEX_VIEW, INDEX_VIEW + ".html"})
    public String index() {
        return INDEX_VIEW;
    }

}
