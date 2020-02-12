package com.fredrikpedersen.petclinic.controller;

import com.fredrikpedersen.petclinic.services.OwnerService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author Fredrik Pedersen
 * @version 1.0
 * @since 16/01/2020 at 19:19
 */

@RequestMapping("/owners")
@Controller
public class OwnerController {

    private static final String OWNERS_VIEW = "owners/index";
    private static final String ALL_OWNERS_ATTRIBUTE = "owners";
    private final OwnerService ownerService;

    public OwnerController(OwnerService ownerService) {
        this.ownerService = ownerService;
    }

    @RequestMapping({"", "/", "/index", "/index.html"})
    public String listOwners(Model model) {

        model.addAttribute(ALL_OWNERS_ATTRIBUTE, ownerService.findAll());

        return OWNERS_VIEW;
    }

    @RequestMapping("/find")
    public String findOwners() {
        return "notimplementedyet";
    }
}
