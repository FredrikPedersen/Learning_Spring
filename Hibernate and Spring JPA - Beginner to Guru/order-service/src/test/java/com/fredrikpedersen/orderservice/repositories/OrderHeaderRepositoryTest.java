package com.fredrikpedersen.orderservice.repositories;

import com.fredrikpedersen.orderservice.domain.Address;
import com.fredrikpedersen.orderservice.domain.OrderHeader;
import com.fredrikpedersen.orderservice.domain.OrderStatus;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.ActiveProfiles;

import static com.fredrikpedersen.orderservice.domain.OrderStatus.NEW;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@DataJpaTest
@ActiveProfiles("local")
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
class OrderHeaderRepositoryTest {

    @Autowired
    private OrderHeaderRepository orderHeaderRepository;

    @Test
    void testSaveOrder() {

        //given
        final OrderHeader orderHeader = OrderHeader.builder()
                .customer("Fredrik")
                .shippingAddress(new Address())
                .billToAddress(new Address())
                .orderStatus(NEW)
                .build();

        //when
        final OrderHeader savedOrder = orderHeaderRepository.save(orderHeader);

        assertNotNull(savedOrder);
        assertNotNull(savedOrder.getId());

        final OrderHeader fetchedOrder = orderHeaderRepository.getById(savedOrder.getId());

        assertNotNull(fetchedOrder);
        assertNotNull(fetchedOrder.getId());
    }
}