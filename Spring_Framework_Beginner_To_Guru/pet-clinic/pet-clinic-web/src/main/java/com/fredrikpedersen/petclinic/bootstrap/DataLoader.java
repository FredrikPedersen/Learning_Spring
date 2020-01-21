package com.fredrikpedersen.petclinic.bootstrap;

import com.fredrikpedersen.petclinic.model.people.Owner;
import com.fredrikpedersen.petclinic.model.people.Veterinary;
import com.fredrikpedersen.petclinic.services.OwnerService;
import com.fredrikpedersen.petclinic.services.VeterinaryService;
import org.springframework.beans.factory.annotation.Autowired;
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

    public DataLoader(OwnerService ownerService, VeterinaryService veterinaryService) {
        this.ownerService = ownerService;
        this.veterinaryService = veterinaryService;
    }

    @Override
    public void run(String... args) throws Exception {
        Owner owner1 = new Owner();
        owner1.setId(1L);
        owner1.setFirstName("Martina");
        owner1.setLastName("Førre");
        ownerService.save(owner1);

        Owner owner2 = new Owner();
        owner2.setId(2L);
        owner2.setFirstName("Signe");
        owner2.setLastName("Eide");
        ownerService.save(owner2);

        System.out.println("Created owner data...");

        Veterinary veterinary1 = new Veterinary();
        veterinary1.setId(1L);
        veterinary1.setFirstName("Victor");
        veterinary1.setLastName("Pishva");
        veterinaryService.save(veterinary1);

        Veterinary veterinary2 = new Veterinary();
        veterinary2.setId(2L);
        veterinary2.setFirstName("Nikita");
        veterinary2.setLastName("Petrovs");
        veterinaryService.save(veterinary2);

        System.out.println("Created veterinary data...");

    }
}
