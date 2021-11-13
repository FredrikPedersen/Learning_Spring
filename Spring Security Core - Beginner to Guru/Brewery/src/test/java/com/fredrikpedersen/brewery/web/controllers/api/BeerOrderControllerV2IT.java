package com.fredrikpedersen.brewery.web.controllers.api;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fredrikpedersen.brewery.bootstrap.DataLoader;
import com.fredrikpedersen.brewery.domain.Beer;
import com.fredrikpedersen.brewery.domain.BeerOrder;
import com.fredrikpedersen.brewery.domain.Customer;
import com.fredrikpedersen.brewery.repositories.BeerOrderRepository;
import com.fredrikpedersen.brewery.repositories.BeerRepository;
import com.fredrikpedersen.brewery.repositories.CustomerRepository;
import com.fredrikpedersen.brewery.web.controllers.BaseIT;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.test.context.support.WithUserDetails;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

/**
 * @author Fredrik Pedersen
 * @version 1.0
 * @since 13/11/2021 at 13:34
 */

@SpringBootTest
class BeerOrderControllerV2Test extends BaseIT {
    public static final String API_ROOT = "/api/v2/orders/";

    @Autowired
    CustomerRepository customerRepository;

    @Autowired
    BeerOrderRepository beerOrderRepository;

    @Autowired
    BeerRepository beerRepository;

    @Autowired
    ObjectMapper objectMapper;

    Customer stPeteCustomer;
    Customer dunedinCustomer;
    Customer keyWestCustomer;
    List<Beer> loadedBeers;

    @BeforeEach
    void setUp() {
        stPeteCustomer = customerRepository.findAllByCustomerName(DataLoader.ST_PETE_DISTRIBUTING).orElseThrow();
        dunedinCustomer = customerRepository.findAllByCustomerName(DataLoader.DUNEDIN_DISTRIBUTING).orElseThrow();
        keyWestCustomer = customerRepository.findAllByCustomerName(DataLoader.KEY_WEST_DISTRIBUTORS).orElseThrow();
        loadedBeers = beerRepository.findAll();
    }

    @Test
    void listOrdersNotAuth() throws Exception {
        mockMvc.perform(get(API_ROOT))
                .andExpect(status().isUnauthorized());
    }

    @WithUserDetails(value = "admin")
    @Test
    void listOrdersAdminAuth() throws Exception {
        mockMvc.perform(get(API_ROOT))
                .andExpect(status().isOk());
    }

    @WithUserDetails(value = DataLoader.STPETE_USER)
    @Test
    void listOrdersCustomerAuth() throws Exception {
        mockMvc.perform(get(API_ROOT))
                .andExpect(status().isOk());
    }

    @WithUserDetails(value = DataLoader.DUNEDIN_USER)
    @Test
    void listOrdersCustomerDunedinAuth() throws Exception {
        mockMvc.perform(get(API_ROOT ))
                .andExpect(status().isOk());
    }


    @Disabled
    @Transactional
    @Test
    void getByOrderIdNotAuth() throws Exception {
        final BeerOrder beerOrder = stPeteCustomer.getBeerOrders().stream().findFirst().orElseThrow();

        mockMvc.perform(get(API_ROOT + beerOrder.getId()))
                .andExpect(status().isUnauthorized());
    }

    @Disabled
    @Transactional
    @WithUserDetails("DataLoader")
    @Test
    void getByOrderIdADMIN() throws Exception {
        final BeerOrder beerOrder = stPeteCustomer.getBeerOrders().stream().findFirst().orElseThrow();

        mockMvc.perform(get(API_ROOT + beerOrder.getId()))
                .andExpect(status().is2xxSuccessful());
    }

    @Disabled
    @Transactional
    @WithUserDetails(DataLoader.STPETE_USER)
    @Test
    void getByOrderIdCustomerAuth() throws Exception {
        final BeerOrder beerOrder = stPeteCustomer.getBeerOrders().stream().findFirst().orElseThrow();

        mockMvc.perform(get(API_ROOT + beerOrder.getId()))
                .andExpect(status().is2xxSuccessful());
    }

    @Disabled
    @Transactional
    @WithUserDetails(DataLoader.DUNEDIN_USER)
    @Test
    void getByOrderIdCustomerNOTAuth() throws Exception {
        final BeerOrder beerOrder = stPeteCustomer.getBeerOrders().stream().findFirst().orElseThrow();

        mockMvc.perform(get(API_ROOT + beerOrder.getId()))
                .andExpect(status().isForbidden());
    }
}
