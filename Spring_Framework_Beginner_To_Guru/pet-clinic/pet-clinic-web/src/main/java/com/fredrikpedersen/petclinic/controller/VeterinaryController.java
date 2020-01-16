package com.fredrikpedersen.petclinic.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author Fredrik Pedersen
 * @version 1.0
 * @since 16/01/2020 at 19:06
 */

@Controller
public class VeterinaryController {

    private static final String VETERINARIES_VIEW = "veterinaries";

    @RequestMapping({VETERINARIES_VIEW, VETERINARIES_VIEW + ".html"})
    public String listVeterinaries() {
        return VETERINARIES_VIEW;
    }
}
