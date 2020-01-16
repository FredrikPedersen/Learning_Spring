package com.fredrikpedersen.petclinic.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author Fredrik Pedersen
 * @version 1.0
 * @since 16/01/2020 at 19:19
 */

@Controller
public class OwnerController {

    private static final String OWNERS_VIEW = "owners";

    @RequestMapping({OWNERS_VIEW, OWNERS_VIEW + ".html"})
    public String listOwners() {
        return OWNERS_VIEW;
    }
}
