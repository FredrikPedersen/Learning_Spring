package com.fredrikpedersen.brewery.security.permissions;

import org.springframework.security.access.prepost.PreAuthorize;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

import static com.fredrikpedersen.brewery.security.permissions.Authorities.*;

/**
 * @author Fredrik Pedersen
 * @version 1.0
 * @since 13/11/2021 at 13:16
 */

@Retention(RetentionPolicy.RUNTIME)
@PreAuthorize("hasAuthority(\"" + ADMIN_ORDER_CREATE + "\") " +
        "OR hasAuthority(\"" + CUSTOMER_ORDER_CREATE + "\") " +
        " AND @beerOrderAuthenticationManager.customerIdMatches(authentication, #customerId )")
public @interface BeerOrderCreatePermission {
}

