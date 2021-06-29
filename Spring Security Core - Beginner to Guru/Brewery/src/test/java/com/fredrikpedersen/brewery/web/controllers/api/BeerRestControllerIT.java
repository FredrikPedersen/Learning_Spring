package com.fredrikpedersen.brewery.web.controllers.api;

import com.fredrikpedersen.brewery.web.controllers.BaseIT;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestPostProcessors.httpBasic;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
class BeerRestControllerIT extends BaseIT {

    private final String BASE_URL = "/api/v1/beer/";
    private final String EXISTING_BEER_ID = "97df0c39-90c4-4ae0-b663-453e8e19c311";

    @Test
    void deleteBeerHttpBasic() throws Exception{
        mockMvc.perform(delete(BASE_URL + EXISTING_BEER_ID)
                .with(httpBasic("admin", "password")))
                .andExpect(status().is2xxSuccessful());
    }

    @Test
    void deleteBeerHttpBasicUserRole() throws Exception{
        mockMvc.perform(delete(BASE_URL + EXISTING_BEER_ID)
                .with(httpBasic("user", "password")))
                .andExpect(status().isForbidden());
    }

    @Test
    void deleteBeerHttpBasicCustomerRole() throws Exception{
        mockMvc.perform(delete(BASE_URL + EXISTING_BEER_ID)
                .with(httpBasic("customer", "password")))
                .andExpect(status().isForbidden());
    }

    @Test
    void deleteBeerNoAuth() throws Exception{
        mockMvc.perform(delete(BASE_URL + EXISTING_BEER_ID))
                .andExpect(status().isUnauthorized());
    }

    @Test
    void findBeers() throws Exception{
        mockMvc.perform(get(BASE_URL))
                .andExpect(status().isOk());
    }

    @Test
    void findBeerById() throws Exception{
        mockMvc.perform(get(BASE_URL + EXISTING_BEER_ID))
                .andExpect(status().isOk());
    }

    @Test
    void findBeerByUpc() throws Exception{
        mockMvc.perform(get("/api/v1/beerUpc/0631234200036"))
                .andExpect(status().isOk());
    }

}