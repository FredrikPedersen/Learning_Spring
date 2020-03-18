package com.fredrikpedersen.petclinic.controllers;

import com.fredrikpedersen.petclinic.services.SpecialtyService;
import com.fredrikpedersen.petclinic.services.map.SpecialityMapService;
import com.fredrikpedersen.petclinic.fauxspring.Model;
import com.fredrikpedersen.petclinic.fauxspring.ModelMapImpl;
import com.fredrikpedersen.petclinic.model.Vet;
import com.fredrikpedersen.petclinic.services.VetService;
import com.fredrikpedersen.petclinic.services.map.VetMapService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;

class VetControllerTest {

    VetService vetService;
    SpecialtyService specialtyService;

    VetController vetController;

    @BeforeEach
    void setUp() {
        specialtyService = new SpecialityMapService();
        vetService = new VetMapService(specialtyService);

        vetController = new VetController(vetService);

        Vet vet1 = new Vet(1L, "joe", "buck", null);
        Vet vet2 = new Vet(2L, "Jimmy", "Smith", null);

        vetService.save(vet1);
        vetService.save(vet2);
    }

    @Test
    void listVets() {
        Model model = new ModelMapImpl();

        String view = vetController.listVets(model);

        assertThat("vets/index").isEqualTo(view);

        Set modelAttribute = (Set) ((ModelMapImpl) model).getMap().get("vets");

        assertThat(modelAttribute.size()).isEqualTo(2);
    }
}