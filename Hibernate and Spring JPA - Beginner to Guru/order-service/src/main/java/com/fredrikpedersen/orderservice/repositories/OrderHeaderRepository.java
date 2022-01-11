package com.fredrikpedersen.orderservice.repositories;

import com.fredrikpedersen.orderservice.domain.OrderHeader;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderHeaderRepository extends JpaRepository<OrderHeader, Long> {
}
