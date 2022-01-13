package com.fredrikpedersen.orderservice.repositories;

import com.fredrikpedersen.orderservice.domain.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.ActiveProfiles;

import java.util.Set;

import static com.fredrikpedersen.orderservice.domain.OrderStatus.NEW;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@DataJpaTest
@ActiveProfiles("local")
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
class OrderHeaderRepositoryTest {

    @Autowired
    private OrderHeaderRepository orderHeaderRepository;

    @Autowired
    private ProductRepository productRepository;

    private Product product;

    @BeforeEach
    void setUp() {
        final Product newProduct = new Product("Test Product", ProductStatus.NEW);
        product = productRepository.saveAndFlush(newProduct);
    }

    @Test
    void saveWithOrderLine() {
        //given
        final OrderLine orderLine = OrderLine.builder().quantityOrdered(5).product(product).build();
        final OrderHeader orderHeader = OrderHeader.builder()
                .customer("Fredrik")
                .shippingAddress(new Address())
                .billToAddress(new Address())
                .orderStatus(NEW)
                .orderLines(Set.of(orderLine))
                .build();

        orderLine.setOrderHeader(orderHeader);

        //when
        final OrderHeader savedOrder = orderHeaderRepository.save(orderHeader);

        //then
        assertNotNull(savedOrder);
        assertNotNull(savedOrder.getId());
        assertNotNull(savedOrder.getCreatedDate());
        assertNotNull(savedOrder.getLastModifiedDate());
        assertNotNull(savedOrder.getOrderLines());
        assertEquals(1, savedOrder.getOrderLines().size());
    }

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

        //then
        assertNotNull(savedOrder);
        assertNotNull(savedOrder.getId());
        assertNotNull(savedOrder.getCreatedDate());
        assertNotNull(savedOrder.getLastModifiedDate());
    }
}