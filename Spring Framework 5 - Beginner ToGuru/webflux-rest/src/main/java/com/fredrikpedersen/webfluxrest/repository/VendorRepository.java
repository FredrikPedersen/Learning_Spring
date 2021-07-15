package com.fredrikpedersen.webfluxrest.repository;

import com.fredrikpedersen.webfluxrest.domain.Vendor;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

/**
 * @author Fredrik Pedersen
 * @version 1.0
 * @since 15/07/2021 at 17:06
 */

public interface VendorRepository extends ReactiveMongoRepository<Vendor, String> {
}
