package com.fredrikpedersen.brewery.security.permissions;

import org.springframework.security.access.prepost.PreAuthorize;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

import static com.fredrikpedersen.brewery.security.permissions.Authorities.ADMIN_ORDER_READ;
import static com.fredrikpedersen.brewery.security.permissions.Authorities.CUSTOMER_ORDER_READ;

/**
 * @author Fredrik Pedersen
 * @version 1.0
 * @since 13/11/2021 at 13:07
 */

@Retention(RetentionPolicy.RUNTIME)
@PreAuthorize("hasAuthority(\"" + ADMIN_ORDER_READ + "\") " +
        "OR hasAuthority(\"" + CUSTOMER_ORDER_READ + "\") " +
        "AND @beerOrderAuthenticationManager.customerIdMatches(authentication, #customerId)")
public @interface BeerOrderReadPermission {
}
