package com.fredrikpedersen.petclinic.services.springdatajpa;

import com.fredrikpedersen.petclinic.model.people.veterinarians.Veterinary;
import com.fredrikpedersen.petclinic.repositories.VeterinaryRepository;
import com.fredrikpedersen.petclinic.services.VeterinaryService;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

/**
 * @author Fredrik Pedersen
 * @version 1.0
 * @since 04.02.2020 at 14:57
 */

@Service
@Profile("springdatajpa")
public class VeterinarySDJpaService implements VeterinaryService {

    private final VeterinaryRepository veterinaryRepository;

    public VeterinarySDJpaService(VeterinaryRepository veterinaryRepository) {
        this.veterinaryRepository = veterinaryRepository;
    }

    @Override
    public Set<Veterinary> findAll() {
        Set<Veterinary> veterinaries = new HashSet<>();
        veterinaryRepository.findAll().forEach(veterinaries::add);

        return veterinaries;
    }

    @Override
    public Veterinary findById(Long id) {
        return veterinaryRepository.findById(id).orElse(null);
    }

    @Override
    public Veterinary save(Veterinary veterinary) {
        return veterinaryRepository.save(veterinary);
    }

    @Override
    public void delete(Veterinary veterinary) {
        veterinaryRepository.delete(veterinary);
    }

    @Override
    public void deleteById(Long id) {
        veterinaryRepository.deleteById(id);
    }
}
