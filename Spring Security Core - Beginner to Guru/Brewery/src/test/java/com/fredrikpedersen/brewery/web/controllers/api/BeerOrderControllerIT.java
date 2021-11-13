package com.fredrikpedersen.brewery.web.controllers.api;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fredrikpedersen.brewery.bootstrap.DataLoader;
import com.fredrikpedersen.brewery.domain.Beer;
import com.fredrikpedersen.brewery.domain.Customer;
import com.fredrikpedersen.brewery.repositories.BeerOrderRepository;
import com.fredrikpedersen.brewery.repositories.BeerRepository;
import com.fredrikpedersen.brewery.repositories.CustomerRepository;
import com.fredrikpedersen.brewery.web.controllers.BaseIT;
import com.fredrikpedersen.brewery.web.model.BeerOrderDto;
import com.fredrikpedersen.brewery.web.model.BeerOrderLineDto;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.security.test.context.support.WithUserDetails;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.UUID;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

/**
 * @author Fredrik Pedersen
 * @version 1.0
 * @since 13/11/2021 at 12:38
 */

@SpringBootTest
class BeerOrderControllerIT extends BaseIT {

    private static final String API_ROOT = "/api/v1/customers/";

    @Autowired
    private CustomerRepository customerRepository;

    @Autowired
    private BeerOrderRepository beerOrderRepository;

    @Autowired
    private BeerRepository beerRepository;

    @Autowired
    private ObjectMapper objectMapper;

    private Customer stPeteCustomer;
    private Customer dunedinCustomer;
    private Customer keyWestCustomer;
    private List<Beer> loadedBeers;

    @BeforeEach
    void setUp() {
        stPeteCustomer = customerRepository.findAllByCustomerName(DataLoader.ST_PETE_DISTRIBUTING).orElseThrow();
        dunedinCustomer = customerRepository.findAllByCustomerName(DataLoader.DUNEDIN_DISTRIBUTING).orElseThrow();
        keyWestCustomer = customerRepository.findAllByCustomerName(DataLoader.KEY_WEST_DISTRIBUTORS).orElseThrow();
        loadedBeers = beerRepository.findAll();
    }

    @Test
    void createOrderNotAuth() throws Exception {
        final BeerOrderDto beerOrderDto = buildOrderDto(stPeteCustomer, loadedBeers.get(0).getId());

        mockMvc.perform(post(API_ROOT + stPeteCustomer.getId() + "/orders")
                .accept(MediaType.APPLICATION_JSON)
                .characterEncoding("UTF-8")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(beerOrderDto)))
                .andExpect(status().isUnauthorized());
    }

    @WithUserDetails("admin")
    @Test
    void createOrderUserAdmin() throws Exception {
        BeerOrderDto beerOrderDto = buildOrderDto(stPeteCustomer, loadedBeers.get(0).getId());

        mockMvc.perform(post(API_ROOT + stPeteCustomer.getId() + "/orders")
                .accept(MediaType.APPLICATION_JSON)
                .characterEncoding("UTF-8")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(beerOrderDto)))
                .andExpect(status().isCreated());
    }

    @WithUserDetails(DataLoader.STPETE_USER)
    @Test
    void createOrderUserAuthCustomer() throws Exception {
        BeerOrderDto beerOrderDto = buildOrderDto(stPeteCustomer, loadedBeers.get(0).getId());

        mockMvc.perform(post(API_ROOT + stPeteCustomer.getId() + "/orders")
                .accept(MediaType.APPLICATION_JSON)
                .characterEncoding("UTF-8")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(beerOrderDto)))
                .andExpect(status().isCreated());
    }

    @WithUserDetails(DataLoader.KEYWEST_USER)
    @Test
    void createOrderUserNOTAuthCustomer() throws Exception {
        BeerOrderDto beerOrderDto = buildOrderDto(stPeteCustomer, loadedBeers.get(0).getId());

        mockMvc.perform(post(API_ROOT + stPeteCustomer.getId() + "/orders")
                .accept(MediaType.APPLICATION_JSON)
                .characterEncoding("UTF-8")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(beerOrderDto)))
                .andExpect(status().isForbidden());
    }

    // }
    @Test
    void listOrdersNotAuth() throws Exception {
        mockMvc.perform(get(API_ROOT + stPeteCustomer.getId() + "/orders"))
                .andExpect(status().isUnauthorized());
    }

    @WithUserDetails(value = "admin")
    @Test
    void listOrdersAdminAuth() throws Exception {
        mockMvc.perform(get(API_ROOT + stPeteCustomer.getId() + "/orders"))
                .andExpect(status().isOk());
    }

    @WithUserDetails(value = DataLoader.STPETE_USER)
    @Test
    void listOrdersCustomerAuth() throws Exception {
        mockMvc.perform(get(API_ROOT + stPeteCustomer.getId() + "/orders"))
                .andExpect(status().isOk());
    }

    @WithUserDetails(value = DataLoader.DUNEDIN_USER)
    @Test
    void listOrdersCustomerNOTAuth() throws Exception {
        mockMvc.perform(get(API_ROOT + stPeteCustomer.getId() + "/orders"))
                .andExpect(status().isForbidden());
    }

    @Test
    void listOrdersNoAuth() throws Exception {
        mockMvc.perform(get(API_ROOT + stPeteCustomer.getId()))
                .andExpect(status().isUnauthorized());
    }

    @Disabled
    @Test
    void pickUpOrderNotAuth() {
    }

    @Disabled
    @Test
    void pickUpOrderNotAdminUser() {
    }

    @Disabled
    @Test
    void pickUpOrderCustomerUserAUTH() {
    }

    @Disabled
    @Test
    void pickUpOrderCustomerUserNOT_AUTH() {
    }

    private BeerOrderDto buildOrderDto(Customer customer, UUID beerId) {
        final List<BeerOrderLineDto> orderLines = Collections.singletonList(BeerOrderLineDto.builder()
                .id(UUID.randomUUID())
                .beerId(beerId)
                .orderQuantity(5)
                .build());

        return BeerOrderDto.builder()
                .customerId(customer.getId())
                .customerRef("123")
                .orderStatusCallbackUrl("http://example.com")
                .beerOrderLines(orderLines)
                .build();
    }
}
