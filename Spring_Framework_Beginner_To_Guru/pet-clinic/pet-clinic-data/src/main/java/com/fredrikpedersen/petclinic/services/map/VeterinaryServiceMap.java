package com.fredrikpedersen.petclinic.services.map;

import com.fredrikpedersen.petclinic.model.people.Veterinary;
import com.fredrikpedersen.petclinic.services.CrudService;

import java.util.Set;

/**
 * @author Fredrik Pedersen
 * @version 1.0
 * @since 16/01/2020 at 14:30
 */

public class VeterinaryServiceMap extends AbstractMapService<Veterinary, Long> implements CrudService<Veterinary, Long> {

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
        return super.save(veterinary.getId(), veterinary);
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
