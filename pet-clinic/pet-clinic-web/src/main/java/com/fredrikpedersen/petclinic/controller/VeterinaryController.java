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

@RequestMapping("/veterinarians")
@Controller
public class VeterinaryController {

    private static final String VETERINARIANS_VIEW = "veterinarians";
    private static final String ALL_VETERINARIANS_ATTRIBUTE = "veterinarians";
    private final VeterinaryService veterinaryService;

    public VeterinaryController(VeterinaryService veterinaryService) {
        this.veterinaryService = veterinaryService;
    }

    @RequestMapping("")
    public String listVeterinarians(Model model) {

        model.addAttribute(ALL_VETERINARIANS_ATTRIBUTE, veterinaryService.findAll());

        return VETERINARIANS_VIEW;
    }
}
