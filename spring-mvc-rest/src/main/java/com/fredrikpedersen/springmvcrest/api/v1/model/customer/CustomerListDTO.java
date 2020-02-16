package com.fredrikpedersen.springmvcrest.api.v1.model.customer;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * @author Fredrik Pedersen
 * @version 1.0
 * @since 16/02/2020 at 17:46
 */

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CustomerListDTO {

    List<CustomerDTO> customers;
}
