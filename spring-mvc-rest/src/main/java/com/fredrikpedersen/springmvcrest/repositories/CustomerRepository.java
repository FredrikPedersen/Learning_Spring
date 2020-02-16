package com.fredrikpedersen.springmvcrest.repositories;

import com.fredrikpedersen.springmvcrest.domain.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author Fredrik Pedersen
 * @version 1.0
 * @since 16/02/2020 at 17:52
 */
public interface CustomerRepository extends JpaRepository<Customer, Long> {
    Customer findByName(final String name);
}
