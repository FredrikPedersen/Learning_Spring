package com.fredrikpedersen.brewery.web.controllers;

import com.fredrikpedersen.brewery.domain.BeerOrder;
import com.fredrikpedersen.brewery.repositories.BeerInventoryRepository;
import com.fredrikpedersen.brewery.repositories.BeerRepository;
import com.fredrikpedersen.brewery.repositories.CustomerRepository;
import com.fredrikpedersen.brewery.services.BeerOrderService;
import com.fredrikpedersen.brewery.services.BeerService;
import com.fredrikpedersen.brewery.services.BreweryService;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest
public class IndexControllerIT extends BaseIT {

    @MockBean
    protected BeerRepository beerRepository;

    @MockBean
    protected BeerInventoryRepository beerInventoryRepository;

    @MockBean
    protected BreweryService breweryService;

    @MockBean
    protected CustomerRepository customerRepository;

    @MockBean
    protected BeerService beerService;

    @MockBean
    protected BeerOrderService beerOrderService;

    @Test
    void testGetIndexSlash() throws Exception{
        mockMvc.perform(get("/"))
                .andExpect(status().isOk());
    }
}
