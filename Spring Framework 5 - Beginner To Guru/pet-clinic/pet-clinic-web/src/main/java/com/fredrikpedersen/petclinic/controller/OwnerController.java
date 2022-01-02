package com.fredrikpedersen.petclinic.controller;

import com.fredrikpedersen.petclinic.model.people.owners.Owner;
import com.fredrikpedersen.petclinic.services.OwnerService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
import java.util.List;

/**
 * @author Fredrik Pedersen
 * @version 1.3
 * @since 31.03.2021 at 11:26
 */

@RequiredArgsConstructor
@RequestMapping("/owners")
@Controller
public class OwnerController {

    private final static String BASE_VIEW = "owners/";
    private final static String FIND_OWNERS_VIEW = BASE_VIEW + "findOwners";
    private final static String OWNER_LIST_VIEW = BASE_VIEW + "ownersList";
    private final static String OWNER_DETAILS_VIEW = BASE_VIEW + "ownerDetails";
    private final static String CREATE_OR_UPDATE_VIEW = BASE_VIEW + "createOrUpdateOwnerForm";

    private final OwnerService ownerService;

    @InitBinder
    public void setAllowedFields(final WebDataBinder dataBinder) {
        dataBinder.setAllowedFields("id");
    }

    @RequestMapping("/find")
    public String findOwners(final Model model) {
        model.addAttribute("owner", Owner.builder().build());
        return FIND_OWNERS_VIEW;
    }

    @GetMapping
    public String processFindForm(final Owner owner, final BindingResult result, final Model model) {
        // allow parameterless GET request for /owners to return all records
        if (owner.getLastName() == null) {
            owner.setLastName(""); // empty string signifies broadest possible search
        }

        // find owners by last name
        final List<Owner> results = ownerService.findAllByLastNameLike("%" + owner.getLastName() + "%");

        if (results.isEmpty()) {
            // no owners found
            result.rejectValue("lastName", "notFound", "not found");
            return FIND_OWNERS_VIEW;

        } else if (results.size() == 1) {
            // 1 owner found
            final Owner resultOwner = results.get(0);
            return "redirect:/" + BASE_VIEW + resultOwner.getId();

        } else {
            // multiple owners found
            model.addAttribute("selections", results);
            return OWNER_LIST_VIEW;
        }
    }

    @GetMapping("/{ownerId}")
    public ModelAndView showOwner(@PathVariable final Long ownerId) {
        ModelAndView mav = new ModelAndView(OWNER_DETAILS_VIEW);
        mav.addObject(ownerService.findById(ownerId));
        return mav;
    }

    @GetMapping("/new")
    public String initCreationForm(final Model model) {
        model.addAttribute("owner", Owner.builder().build());
        return CREATE_OR_UPDATE_VIEW;
    }

    @PostMapping("/new")
    public String processCreationForm(@Valid final Owner owner, final BindingResult result) {
        if (result.hasErrors()) {
            return CREATE_OR_UPDATE_VIEW;
        } else {
            final Owner savedOwner =  ownerService.save(owner);
            return "redirect:/" + BASE_VIEW + savedOwner.getId();
        }
    }

    @GetMapping("/{ownerId}/edit")
    public String initUpdateOwnerForm(@PathVariable final Long ownerId, final Model model) {
        model.addAttribute(ownerService.findById(ownerId));
        return CREATE_OR_UPDATE_VIEW;
    }

    @PostMapping("/{ownerId}/edit")
    public String processUpdateOwnerForm(@Valid final Owner owner, final BindingResult result, @PathVariable final Long ownerId) {
        if (result.hasErrors()) {
            return CREATE_OR_UPDATE_VIEW;
        } else {
            owner.setId(ownerId);
            final Owner savedOwner = ownerService.save(owner);
            return "redirect:/" + BASE_VIEW + savedOwner.getId();
        }
    }
}
