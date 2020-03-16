package com.fredrikpedersen.springmvcrest.services.customer;

import com.fredrikpedersen.springmvcrest.api.v1.mapper.CustomerMapper;
import com.fredrikpedersen.springmvcrest.api.v1.model.customer.CustomerDTO;
import com.fredrikpedersen.springmvcrest.bootstrap.DataLoader;
import com.fredrikpedersen.springmvcrest.domain.Customer;
import com.fredrikpedersen.springmvcrest.repositories.CategoryRepository;
import com.fredrikpedersen.springmvcrest.repositories.CustomerRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.hamcrest.core.IsEqual.equalTo;
import static org.hamcrest.core.IsNot.not;
import static org.hamcrest.MatcherAssert.assertThat;

/**
 * @author Fredrik Pedersen
 * @version 1.0
 * @since 17/02/2020 at 18:39
 */

@ExtendWith(SpringExtension.class)
@DataJpaTest
class CustomerServiceImplIT {

    @Autowired
    CustomerRepository customerRepository;

    @Autowired
    CategoryRepository categoryRepository;

    CustomerService customerService;

    @BeforeEach
    void setUp() throws Exception {
        System.out.println("Loading Customer Data");
        System.out.println(customerRepository.findAll().size());

        //setup data for testing
        DataLoader dataLoader = new DataLoader(categoryRepository, customerRepository);
        dataLoader.run();

        customerService = new CustomerServiceImpl(CustomerMapper.INSTANCE, customerRepository);
    }

    @Test
    void patchCustomerUpdateFirstNameTest() throws Exception {
        String updatedName = "UpdatedName";
        long id = getCustomerIdValue();

        Customer originalCustomer = customerRepository.getOne(id);
        assertNotNull(originalCustomer);

        String originalFirstName = originalCustomer.getFirstName();
        String originalLastName = originalCustomer.getLastName();

        CustomerDTO customerDTO = new CustomerDTO();
        customerDTO.setFirstName(updatedName);

        customerService.patchCustomer(id, customerDTO);

        Customer updatedCustomer = customerRepository.findById(id).get();

        assertNotNull(updatedCustomer);
        assertEquals(updatedName, updatedCustomer.getFirstName());
        assertThat(originalFirstName, not(equalTo(updatedCustomer.getFirstName())));
        assertThat(originalLastName, equalTo(updatedCustomer.getLastName()));
    }

    @Test
    void patchCustomerUpdateLastNameTest() throws Exception {
        String updatedName = "UpdatedName";
        long id = getCustomerIdValue();

        Customer originalCustomer = customerRepository.getOne(id);
        assertNotNull(originalCustomer);

        String originalFirstName = originalCustomer.getFirstName();
        String originalLastName = originalCustomer.getLastName();

        CustomerDTO customerDTO = new CustomerDTO();
        customerDTO.setLastName(updatedName);

        customerService.patchCustomer(id, customerDTO);

        Customer updatedCustomer = customerRepository.findById(id).get();

        assertNotNull(updatedCustomer);
        assertEquals(updatedName, updatedCustomer.getLastName());
        assertThat(originalLastName, not(equalTo(updatedCustomer.getLastName())));
        assertThat(originalFirstName, equalTo(updatedCustomer.getFirstName()));
    }

    private Long getCustomerIdValue() {
        List<Customer> customers = customerRepository.findAll();

        System.out.println("Customers found: " + customers.size());

        return customers.get(0).getId();
    }
}