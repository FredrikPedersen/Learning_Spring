package com.fredrikpedersen.springmvcrest.api.v1.mapper;

import com.fredrikpedersen.springmvcrest.api.v1.model.customer.CustomerDTO;
import com.fredrikpedersen.springmvcrest.domain.Customer;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

/**
 * @author Fredrik Pedersen
 * @version 1.0
 * @since 16/02/2020 at 17:47
 */

@Mapper
public interface CustomerMapper {

    CustomerMapper INSTANCE = Mappers.getMapper(CustomerMapper.class);

    CustomerDTO customerToCustomerDTO(final Customer customer);
    Customer customerDtoToCustomer(final CustomerDTO customerDTO);

}
