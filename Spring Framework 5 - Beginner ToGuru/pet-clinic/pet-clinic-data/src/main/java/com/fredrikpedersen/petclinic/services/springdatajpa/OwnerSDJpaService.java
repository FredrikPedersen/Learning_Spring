package com.fredrikpedersen.petclinic.services.springdatajpa;

import com.fredrikpedersen.petclinic.model.people.owners.Owner;
import com.fredrikpedersen.petclinic.repositories.OwnerRepository;
import com.fredrikpedersen.petclinic.services.OwnerService;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author Fredrik Pedersen
 * @version 1.1
 * @since 31.03.2021 at 10:32
 */

@Component
@Profile("springdatajpa")
public class OwnerSDJpaService implements OwnerService {

    private final OwnerRepository ownerRepository;

    public OwnerSDJpaService(final OwnerRepository ownerRepository) {
        this.ownerRepository = ownerRepository;
    }

    @Override
    public Owner findByLastName(final String lastName) {
        return ownerRepository.findByLastName(lastName);
    }

    @Override
    public List<Owner> findAllByLastNameLike(final String lastname) {
        return ownerRepository.findAllByLastNameLike(lastname);
    }

    @Override
    public Set<Owner> findAll() {
        Set<Owner> owners = new HashSet<>();
        ownerRepository.findAll().forEach(owners::add);
        return owners;
    }

    @Override
    public Owner findById(final Long id) {
        return ownerRepository.findById(id).orElse(null);
    }

    @Override
    public Owner save(final Owner owner) {
        return ownerRepository.save(owner);
    }

    @Override
    public void delete(final Owner owner) {
        ownerRepository.delete(owner);
    }

    @Override
    public void deleteById(final Long id) {
        ownerRepository.deleteById(id);
    }
}
