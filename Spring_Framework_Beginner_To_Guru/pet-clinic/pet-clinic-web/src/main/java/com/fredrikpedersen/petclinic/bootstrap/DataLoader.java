package com.fredrikpedersen.petclinic.bootstrap;

import com.fredrikpedersen.petclinic.model.people.owners.Owner;
import com.fredrikpedersen.petclinic.model.people.veterinarians.Speciality;
import com.fredrikpedersen.petclinic.model.people.veterinarians.Veterinary;
import com.fredrikpedersen.petclinic.model.pets.Pet;
import com.fredrikpedersen.petclinic.model.pets.PetType;
import com.fredrikpedersen.petclinic.services.OwnerService;
import com.fredrikpedersen.petclinic.services.PetTypeService;
import com.fredrikpedersen.petclinic.services.SpecialityService;
import com.fredrikpedersen.petclinic.services.VeterinaryService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

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
    private final SpecialityService specialityService;

    public DataLoader(OwnerService ownerService, VeterinaryService veterinaryService, PetTypeService petTypeService, SpecialityService specialityService) {
        this.ownerService = ownerService;
        this.veterinaryService = veterinaryService;
        this.petTypeService = petTypeService;
        this.specialityService = specialityService;
    }

    @Override
    public void run(String... args) throws Exception {
        int count = petTypeService.findAll().size();

        if (count == 0) {
            loadData();
        }
    }

    private void loadData() {
        /* ----- Pet Types ----- */

        PetType petType1 = new PetType();
        petType1.setName("Dog");
        PetType savedPetype1 = petTypeService.save(petType1);
        System.out.println("Created pet type data...");

        PetType petType2 = new PetType();
        petType2.setName("Cat");
        PetType savedPetype2 = petTypeService.save(petType2);

        /* ----- Owners ----- */

        Owner owner1 = new Owner();
        owner1.setFirstName("Martina");
        owner1.setLastName("Førre");
        owner1.setAddress("123 Østkanten");
        owner1.setCity("Oslo");
        owner1.setTelephone("12345678");

        Pet pet1 = new Pet();
        pet1.setPetType(savedPetype1);
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
        pet2.setPetType(savedPetype2);
        pet2.setBirthDate(LocalDate.now());
        pet2.setName("Salem");
        owner2.getPets().add(pet2);

        ownerService.save(owner2);
        System.out.println("Created owner data...");

        /* ----- Specialities ----- */

        Speciality speciality1 = new Speciality();
        speciality1.setDescription("Radiology");
        Speciality savedSpeciality1 = specialityService.save(speciality1);

        Speciality speciality2 = new Speciality();
        speciality2.setDescription("Surgery");
        Speciality savedSpeciality2 = specialityService.save(speciality2);

        Speciality speciality3 = new Speciality();
        speciality3.setDescription("Dentistry");
        Speciality savedSpeciality3 = specialityService.save(speciality3);

        /* ----- Veterinarians ----- */

        Veterinary veterinary1 = new Veterinary();
        veterinary1.setFirstName("Victor");
        veterinary1.setLastName("Pishva");
        veterinary1.getSpecialities().add(savedSpeciality1);
        veterinaryService.save(veterinary1);

        Veterinary veterinary2 = new Veterinary();
        veterinary2.setFirstName("Nikita");
        veterinary2.setLastName("Petrovs");
        veterinary2.getSpecialities().add(savedSpeciality2);
        veterinaryService.save(veterinary2);
        System.out.println("Created veterinary data...");
    }
}
