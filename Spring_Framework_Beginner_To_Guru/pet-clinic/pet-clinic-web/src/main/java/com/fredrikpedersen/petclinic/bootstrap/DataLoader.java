package com.fredrikpedersen.petclinic.bootstrap;

import com.fredrikpedersen.petclinic.model.people.owners.Owner;
import com.fredrikpedersen.petclinic.model.people.veterinaries.Veterinary;
import com.fredrikpedersen.petclinic.model.pets.PetType;
import com.fredrikpedersen.petclinic.services.OwnerService;
import com.fredrikpedersen.petclinic.services.PetTypeService;
import com.fredrikpedersen.petclinic.services.VeterinaryService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

/**
 * @author Fredrik Pedersen
 * @version 1.0
 * @since 21/01/2020 at 15:40
 */

@Component
public class DataLoader implements CommandLineRunner {

    private final OwnerService ownerService;
    private final VeterinaryService veterinaryService;
    private final PetTypeService petTypeService;

    public DataLoader(OwnerService ownerService, VeterinaryService veterinaryService, PetTypeService petTypeService) {
        this.ownerService = ownerService;
        this.veterinaryService = veterinaryService;
        this.petTypeService = petTypeService;
    }

    @Override
    public void run(String... args) throws Exception {
        createOwners();
        System.out.println("Created owner data...");

        createVeterinaries();
        System.out.println("Created veterinary data...");

        createPetTypes();
        System.out.println("Created pet type data...");

    }

    private void createOwners() {
        Owner owner = new Owner();
        owner.setFirstName("Martina");
        owner.setLastName("Førre");
        ownerService.save(owner);

        owner = new Owner();
        owner.setFirstName("Signe");
        owner.setLastName("Eide");
        ownerService.save(owner);
    }

    private void createVeterinaries() {
        Veterinary veterinary = new Veterinary();
        veterinary.setFirstName("Victor");
        veterinary.setLastName("Pishva");
        veterinaryService.save(veterinary);

        veterinary = new Veterinary();
        veterinary.setFirstName("Nikita");
        veterinary.setLastName("Petrovs");
        veterinaryService.save(veterinary);
    }

    private void createPetTypes() {
        PetType petType = new PetType();
        petType.setName("Dog");
        petTypeService.save(petType);

        petType = new PetType();
        petType.setName("Cat");
        petTypeService.save(petType);
    }
}
