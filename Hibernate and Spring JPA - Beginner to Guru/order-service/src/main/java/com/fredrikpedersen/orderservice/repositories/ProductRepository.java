package com.fredrikpedersen.orderservice.repositories;

import com.fredrikpedersen.orderservice.domain.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {
}
