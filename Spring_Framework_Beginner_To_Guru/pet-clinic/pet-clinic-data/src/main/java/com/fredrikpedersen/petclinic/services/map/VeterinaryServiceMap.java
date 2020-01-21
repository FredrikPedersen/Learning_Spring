package com.fredrikpedersen.petclinic.services.map;

import com.fredrikpedersen.petclinic.model.people.Veterinary;
import com.fredrikpedersen.petclinic.services.VeterinaryService;
import org.springframework.stereotype.Service;

import java.util.Set;

/**
 * @author Fredrik Pedersen
 * @version 1.0
 * @since 16/01/2020 at 14:30
 */

@Service
public class VeterinaryServiceMap extends AbstractMapService<Veterinary, Long> implements VeterinaryService {

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
