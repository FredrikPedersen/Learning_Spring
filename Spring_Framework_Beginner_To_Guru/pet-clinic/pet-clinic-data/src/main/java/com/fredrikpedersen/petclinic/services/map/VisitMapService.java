package com.fredrikpedersen.petclinic.services.map;

import com.fredrikpedersen.petclinic.model.Visit;
import com.fredrikpedersen.petclinic.services.VisitService;
import org.springframework.stereotype.Service;

import java.util.Set;

/**
 * @author Fredrik Pedersen
 * @version 1.0
 * @since 04.02.2020 at 15:20
 */

@Service
public class VisitMapService extends AbstractMapService<Visit, Long> implements VisitService {

    private final VisitService visitService;

    public VisitMapService(VisitService visitService) {
        this.visitService = visitService;
    }

    @Override
    public Set<Visit> findAll() {
        return super.findAll();
    }

    @Override
    public void deleteById(Long id) {
        super.deleteById(id);
    }

    @Override
    public void delete(Visit visit) {
        super.delete(visit);
    }

    @Override
    public Visit save(Visit visit) {

        if (visit.getPet() == null || visit.getPet().getOwner() == null || visit.getPet().getId() == null ||
            visit.getPet().getOwner().getId() == null)  {
            throw new RuntimeException("Invalid Visit");
        }

        return super.save(visit);
    }

    @Override
    public Visit findById(Long id) {
        return super.findById(id);
    }
}
