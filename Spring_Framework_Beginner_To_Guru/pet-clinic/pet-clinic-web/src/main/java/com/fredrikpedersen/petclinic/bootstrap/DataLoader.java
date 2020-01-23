package com.fredrikpedersen.petclinic.bootstrap;

import com.fredrikpedersen.petclinic.model.people.owners.Owner;
import com.fredrikpedersen.petclinic.model.people.veterinaries.Veterinary;
import com.fredrikpedersen.petclinic.model.pets.Pet;
import com.fredrikpedersen.petclinic.model.pets.PetType;
import com.fredrikpedersen.petclinic.services.OwnerService;
import com.fredrikpedersen.petclinic.services.PetTypeService;
import com.fredrikpedersen.petclinic.services.VeterinaryService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Set;

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

        /* ----- Pet Types ----- */

        PetType petType1 = new PetType();
        petType1.setName("Dog");
        petTypeService.save(petType1);
        System.out.println("Created pet type data...");

        PetType petType2 = new PetType();
        petType2.setName("Cat");
        petTypeService.save(petType2);

        /* ----- Owners ----- */

        Owner owner1 = new Owner();
        owner1.setFirstName("Martina");
        owner1.setLastName("Førre");
        owner1.setAddress("123 Østkanten");
        owner1.setCity("Oslo");
        owner1.setTelephone("12345678");

        Pet pet1 = new Pet();
        pet1.setPetType(petType1);
        pet1.setBirthDate(LocalDate.now());
        pet1.setName("Sudo");
        owner1.getPets().add(pet1);
        ownerService.save(owner1);

        Owner owner2 = new Owner();
        owner2.setFirstName("Signe");
        owner2.setLastName("Eide");
        owner1.setAddress("123 Vestkanten");
        owner1.setCity("Oslo");
        owner1.setTelephone("87654321");

        Pet pet2 = new Pet();
        pet2.setPetType(petType2);
        pet2.setBirthDate(LocalDate.now());
        pet2.setName("Salem");
        owner2.getPets().add(pet2);

        ownerService.save(owner2);
        System.out.println("Created owner data...");

        /* ----- Veterinaries ----- */

        Veterinary veterinary1 = new Veterinary();
        veterinary1.setFirstName("Victor");
        veterinary1.setLastName("Pishva");
        veterinaryService.save(veterinary1);

        Veterinary veterinary2 = new Veterinary();
        veterinary2.setFirstName("Nikita");
        veterinary2.setLastName("Petrovs");
        veterinaryService.save(veterinary2);
        System.out.println("Created veterinary data...");
    }
}
