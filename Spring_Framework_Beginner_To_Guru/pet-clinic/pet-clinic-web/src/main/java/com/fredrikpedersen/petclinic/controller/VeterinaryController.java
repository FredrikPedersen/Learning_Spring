package com.fredrikpedersen.petclinic.controller;

import com.fredrikpedersen.petclinic.services.VeterinaryService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author Fredrik Pedersen
 * @version 1.0
 * @since 16/01/2020 at 19:06
 */

@Controller
public class VeterinaryController {

    private static final String VETERINARIES_VIEW = "veterinaries";
    private static final String ALL_VETERINARIES_ATTRIBUTE = "veterinaries";
    private final VeterinaryService veterinaryService;

    public VeterinaryController(VeterinaryService veterinaryService) {
        this.veterinaryService = veterinaryService;
    }

    @RequestMapping({VETERINARIES_VIEW, VETERINARIES_VIEW + ".html"})
    public String listVeterinaries(Model model) {

        model.addAttribute(ALL_VETERINARIES_ATTRIBUTE, veterinaryService.findAll());

        return VETERINARIES_VIEW;
    }
}
