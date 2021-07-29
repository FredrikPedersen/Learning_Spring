package com.fredrikpedersen.webfluxrest.repositories;

import com.fredrikpedersen.webfluxrest.domain.Vendor;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;

/**
 * @author Fredrik Pedersen
 * @version 1.0
 * @since 15/07/2021 at 17:06
 */

@Repository
public interface VendorRepository extends ReactiveMongoRepository<Vendor, String> {
}
