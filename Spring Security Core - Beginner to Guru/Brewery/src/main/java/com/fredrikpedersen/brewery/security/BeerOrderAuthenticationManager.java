package com.fredrikpedersen.brewery.security;

import com.fredrikpedersen.brewery.domain.security.User;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Component;

import java.util.UUID;

/**
 * @author Fredrik Pedersen
 * @version 1.0
 * @since 13/11/2021 at 12:50
 */

@Slf4j
@Component
public class BeerOrderAuthenticationManager {

    public boolean customerIdMatches(final Authentication authentication, final UUID customerId) {
        final User authenticationUser = (User) authentication.getPrincipal();

        log.debug("Auth Customer ID: " + authenticationUser.getCustomer().getId() + " Customer ID: " + customerId);
        return authenticationUser.getCustomer().getId().equals(customerId);
    }

}
