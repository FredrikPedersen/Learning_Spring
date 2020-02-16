package com.fredrikpedersen.springmvcrest.services;

import com.fredrikpedersen.springmvcrest.api.v1.mapper.CustomerMapper;
import com.fredrikpedersen.springmvcrest.api.v1.model.customer.CustomerDTO;
import com.fredrikpedersen.springmvcrest.domain.Customer;
import com.fredrikpedersen.springmvcrest.repositories.CustomerRepository;
import com.fredrikpedersen.springmvcrest.services.customer.CustomerService;
import com.fredrikpedersen.springmvcrest.services.customer.CustomerServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.when;

/**
 * @author Fredrik Pedersen
 * @version 1.0
 * @since 16/02/2020 at 18:07
 */

class CustomerServiceTest {

    private static final Long ID = 2L;
    private static final String NAME = "Jimmy";
    private CustomerService customerService;

    @Mock
    CustomerRepository customerRepository;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);

        customerService = new CustomerServiceImpl(CustomerMapper.INSTANCE, customerRepository);
    }

    @Test
    void getAllCustomersTest() {

        //given
        List<Customer> customers = Arrays.asList(new Customer(), new Customer(), new Customer());
        when(customerRepository.findAll()).thenReturn(customers);

        //when
        List<CustomerDTO> customerDTOs = customerService.getAllCustomers();

        //then
        assertEquals(3, customerDTOs.size());
    }

    @Test
    void getCustomerByNameTest() {

        //given
        Customer customer = new Customer();
        customer.setId(ID);
        customer.setName(NAME);

        when(customerRepository.findByName(anyString())).thenReturn(customer);

        //when
        CustomerDTO customerDTO = customerService.getCustomerByName(NAME);

        //then
        assertEquals(ID, customerDTO.getId());
        assertEquals(NAME, customerDTO.getName());
    }
}