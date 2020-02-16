package com.fredrikpedersen.springmvcrest.api.v1.model.customer;

import lombok.Data;

/**
 * @author Fredrik Pedersen
 * @version 1.0
 * @since 16/02/2020 at 17:46
 */

@Data
public class CustomerDTO {

    private String firstName;
    private String lastName;
    private String customerUrl;
}
