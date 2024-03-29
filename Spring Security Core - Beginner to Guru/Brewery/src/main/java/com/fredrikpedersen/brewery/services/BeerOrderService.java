package com.fredrikpedersen.brewery.services;


import com.fredrikpedersen.brewery.web.model.BeerOrderPagedList;
import com.fredrikpedersen.brewery.web.model.BeerOrderDto;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;

import java.util.UUID;

public interface BeerOrderService {
    BeerOrderPagedList listOrders(UUID customerId, Pageable pageable);

    BeerOrderDto placeOrder(UUID customerId, BeerOrderDto beerOrderDto);

    BeerOrderDto getOrderById(UUID customerId, UUID orderId);

    void pickupOrder(UUID customerId, UUID orderId);

    BeerOrderPagedList listOrders(Pageable pageable);
}
