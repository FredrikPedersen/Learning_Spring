package com.fredrikpedersen.petclinic.services.map;

import com.fredrikpedersen.petclinic.model.people.owners.Owner;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author Fredrik Pedersen
 * @version 1.0
 * @since 12/02/2020 at 20:48
 */

class OwnerMapServiceTest {

    private OwnerMapService ownerMapService;
    private final Long OWNER_ID = 1L;
    private final String LAST_NAME = "Eide";

    @BeforeEach
    void setUp() {
        ownerMapService = new OwnerMapService(new PetTypeMapService(), new PetMapService());
        ownerMapService.save(Owner.builder().id(OWNER_ID).lastName(LAST_NAME).build());
    }

    @Test
    void findAll() {
        Set<Owner> ownerSet = ownerMapService.findAll();

        assertEquals(1, ownerSet.size());
    }

    @Test
    void findById() {
        Owner owner = ownerMapService.findById(OWNER_ID);

        assertEquals(OWNER_ID, owner.getId());
    }

    @Test
    void saveExistingId() {
        Long id = 2L;

        Owner owner = Owner.builder().id(id).build();
        Owner savedOwner = ownerMapService.save(owner);

        assertEquals(id, savedOwner.getId());
    }

    @Test
    void saveNoId() {
        Owner savedOwner = ownerMapService.save(Owner.builder().build());

        assertNotNull(savedOwner);
        assertNotNull(savedOwner.getId());
    }

    @Test
    void delete() {
        ownerMapService.delete(ownerMapService.findById(OWNER_ID));

        assertEquals(0, ownerMapService.findAll().size());
    }

    @Test
    void deleteById() {
        ownerMapService.deleteById(OWNER_ID);

        assertEquals(0, ownerMapService.findAll().size());
    }

    @Test
    void findByLastName() {
        Owner eide = ownerMapService.findByLastName(LAST_NAME);

        assertNotNull(eide);
        assertEquals(OWNER_ID, eide.getId());
        assertEquals(eide.getLastName(), LAST_NAME);
    }

    @Test
    void findByLastNameNotFound() {
        Owner eide = ownerMapService.findByLastName("Pedersen");

        assertNull(eide);
    }
}