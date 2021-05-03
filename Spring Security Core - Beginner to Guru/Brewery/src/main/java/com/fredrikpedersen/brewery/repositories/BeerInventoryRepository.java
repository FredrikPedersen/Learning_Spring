package com.fredrikpedersen.brewery.repositories;

import com.fredrikpedersen.brewery.domain.BeerInventory;
import com.fredrikpedersen.brewery.domain.Beer;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.UUID;

public interface BeerInventoryRepository extends JpaRepository<BeerInventory, UUID> {

    List<BeerInventory> findAllByBeer(Beer beer);
}
