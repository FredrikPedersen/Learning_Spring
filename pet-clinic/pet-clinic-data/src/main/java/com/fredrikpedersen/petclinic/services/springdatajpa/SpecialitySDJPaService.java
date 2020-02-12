package com.fredrikpedersen.petclinic.services.springdatajpa;

import com.fredrikpedersen.petclinic.model.people.veterinarians.Speciality;
import com.fredrikpedersen.petclinic.repositories.SpecialtyRepository;
import com.fredrikpedersen.petclinic.services.SpecialityService;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

/**
 * @author Fredrik Pedersen
 * @version 1.0
 * @since 04.02.2020 at 15:09
 */

@Service
@Profile("springdatajpa")
public class SpecialitySDJPaService implements SpecialityService {

    private final SpecialtyRepository specialtyRepository;

    public SpecialitySDJPaService(SpecialtyRepository specialtyRepository) {
        this.specialtyRepository = specialtyRepository;
    }


    @Override
    public Set<Speciality> findAll() {
        Set<Speciality> specialities = new HashSet<>();
        specialtyRepository.findAll().forEach(specialities::add);
        return specialities;
    }

    @Override
    public Speciality findById(Long id) {
        return specialtyRepository.findById(id).orElse(null);
    }

    @Override
    public Speciality save(Speciality speciality) {
        return specialtyRepository.save(speciality);
    }

    @Override
    public void delete(Speciality speciality) {
        specialtyRepository.delete(speciality);
    }

    @Override
    public void deleteById(Long id) {
        specialtyRepository.deleteById(id);
    }
}
