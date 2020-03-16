package com.fredrikpedersen.springmvcrest.api.v1.mapper;

import com.fredrikpedersen.springmvcrest.api.v1.model.customer.CustomerDTO;
import com.fredrikpedersen.springmvcrest.domain.Customer;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * @author Fredrik Pedersen
 * @version 1.0
 * @since 16/02/2020 at 18:01
 */
class CustomerMapperTest {

    private static final String FIRST_NAME = "Fredrik";
    private static final String LAST_NAME = "Pedersen";
    private static final long ID = 1L;

    CustomerMapper customerMapper = CustomerMapper.INSTANCE;

    @Test
    void customerToCustomerDTOTest() {

        //given
        Customer customer = new Customer();
        customer.setFirstName(FIRST_NAME);
        customer.setLastName(LAST_NAME);
        customer.setId(ID);

        //when
        CustomerDTO customerDTO = customerMapper.customerToCustomerDTO(customer);

        //then
        assertEquals(FIRST_NAME, customerDTO.getFirstName());
        assertEquals(LAST_NAME, customerDTO.getLastName());
    }
}