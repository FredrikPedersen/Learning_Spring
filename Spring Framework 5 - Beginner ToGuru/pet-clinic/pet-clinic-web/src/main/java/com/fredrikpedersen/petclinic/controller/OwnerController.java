package com.fredrikpedersen.petclinic.controller;

import com.fredrikpedersen.petclinic.model.people.owners.Owner;
import com.fredrikpedersen.petclinic.services.OwnerService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

/**
 * @author Fredrik Pedersen
 * @version 1.2
 * @since 31.03.2021 at 10:38
 */

@RequiredArgsConstructor
@RequestMapping("/owners")
@Controller
public class OwnerController {

    private static final String OWNERS_VIEW = "owners/index";
    private static final String ALL_OWNERS_ATTRIBUTE = "owners";
    private final OwnerService ownerService;

    @InitBinder
    public void setAllowedFields(final WebDataBinder dataBinder) {
        dataBinder.setAllowedFields("id");
    }

    @RequestMapping("/find")
    public String findOwners(final Model model) {
        model.addAttribute("owner", Owner.builder().build());
        return "owners/findOwners";
    }

    @GetMapping
    public String processFindForm(final Owner owner, final BindingResult result, final Model model) {
        // allow parameterless GET request for /owners to return all records
        if (owner.getLastName() == null) {
            owner.setLastName(""); // empty string signifies broadest possible search
        }

        // find owners by last name
        final List<Owner> results = ownerService.findAllByLastNameLike("%"+ owner.getLastName() + "%");

        if (results.isEmpty()) {
            // no owners found
            result.rejectValue("lastName", "notFound", "not found");
            return "owners/findOwners";

        } else if (results.size() == 1) {
            // 1 owner found
            final Owner resultOwner = results.get(0);
            return "redirect:/owners/" + resultOwner.getId();

        } else {
            // multiple owners found
            model.addAttribute("selections", results);
            return "owners/ownersList";
        }
    }

    @GetMapping("/{ownerId}")
    public ModelAndView showOwner(@PathVariable("ownerId") final Long ownerId) {
        ModelAndView mav = new ModelAndView("owners/ownerDetails");
        mav.addObject(ownerService.findById(ownerId));
        return mav;
    }
}
