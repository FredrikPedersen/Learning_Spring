package com.fredrikpedersen.brewery.services;

import com.fredrikpedersen.brewery.domain.Brewery;
import com.fredrikpedersen.brewery.repositories.BreweryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class BreweryServiceImpl implements BreweryService{

    private final BreweryRepository breweryRepository;

    @Override
    public List<Brewery> getAllBreweries() {
        return breweryRepository.findAll();
    }
}
