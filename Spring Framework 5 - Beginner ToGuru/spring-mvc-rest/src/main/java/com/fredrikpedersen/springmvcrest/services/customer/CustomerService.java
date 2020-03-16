package com.fredrikpedersen.springmvcrest.services.customer;

import com.fredrikpedersen.springmvcrest.api.v1.model.customer.CustomerDTO;

import java.util.List;

/**
 * @author Fredrik Pedersen
 * @version 1.0
 * @since 16/02/2020 at 17:53
 */
public interface CustomerService {

    List<CustomerDTO> getAllCustomers();
    CustomerDTO getCustomerById(final Long id);
    CustomerDTO createNewCustomer(final CustomerDTO customerDTO);
    CustomerDTO saveCustomerByDTO(final Long id, final CustomerDTO customerDTO);
    CustomerDTO patchCustomer(final Long id, final CustomerDTO customerDTO);
    void deleteCustomerById(final Long id);
}
