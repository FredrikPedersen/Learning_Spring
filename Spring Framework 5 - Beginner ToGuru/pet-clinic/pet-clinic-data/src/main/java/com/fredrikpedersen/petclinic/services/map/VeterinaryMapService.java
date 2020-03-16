package com.fredrikpedersen.petclinic.services.map;

import com.fredrikpedersen.petclinic.model.people.veterinarians.Speciality;
import com.fredrikpedersen.petclinic.model.people.veterinarians.Veterinary;
import com.fredrikpedersen.petclinic.services.SpecialityService;
import com.fredrikpedersen.petclinic.services.VeterinaryService;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import java.util.Set;

/**
 * @author Fredrik Pedersen
 * @version 1.0
 * @since 16/01/2020 at 14:30
 */

@Service
@Profile({"default", "map"})
public class VeterinaryMapService extends AbstractMapService<Veterinary, Long> implements VeterinaryService {

    private final SpecialityService specialityService;

    public VeterinaryMapService(SpecialityService specialityService) {
        this.specialityService = specialityService;
    }

    @Override
    public Set<Veterinary> findAll() {
        return super.findAll();
    }

    @Override
    public Veterinary findById(Long id) {
        return super.findById(id);
    }

    @Override
    public Veterinary save(Veterinary veterinary) {
        if (veterinary.getSpecialities().size() > 0) {
            veterinary.getSpecialities().forEach(speciality -> {
                if (speciality.getId() == null) {
                    Speciality savedSpecialty = specialityService.save(speciality);
                    speciality.setId(savedSpecialty.getId());
                }
            });
        }

        return super.save(veterinary);
    }

    @Override
    public void delete(Veterinary veterinary) {
        super.delete(veterinary);
    }

    @Override
    public void deleteById(Long id) {
        super.deleteById(id);
    }
}
