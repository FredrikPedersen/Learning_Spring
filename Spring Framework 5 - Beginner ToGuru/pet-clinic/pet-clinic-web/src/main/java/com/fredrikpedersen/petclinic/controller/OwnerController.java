package com.fredrikpedersen.petclinic.controller;

import com.fredrikpedersen.petclinic.services.OwnerService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * @author Fredrik Pedersen
 * @version 1.1
 * @since 19/03/2021 at 09:36
 */

@RequiredArgsConstructor
@RequestMapping("/owners")
@Controller
public class OwnerController {

    private static final String OWNERS_VIEW = "owners/index";
    private static final String ALL_OWNERS_ATTRIBUTE = "owners";
    private final OwnerService ownerService;

    @RequestMapping({"", "/", "/index", "/index.html"})
    public String listOwners(final Model model) {

        model.addAttribute(ALL_OWNERS_ATTRIBUTE, ownerService.findAll());

        return OWNERS_VIEW;
    }

    @RequestMapping("/find")
    public String findOwners() {
        return "notimplementedyet";
    }

    @GetMapping("/{ownerId}")
    public ModelAndView showOwner(@PathVariable("ownerId") final Long ownerId) {
        ModelAndView mav = new ModelAndView("owners/ownerDetails");
        mav.addObject(ownerService.findById(ownerId));
        return mav;
    }
}
