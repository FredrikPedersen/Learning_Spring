package com.fredrikpedersen.brewery.security.permissions;

import org.springframework.security.access.prepost.PreAuthorize;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

import static com.fredrikpedersen.brewery.security.permissions.Authorities.*;

/**
 * @author Fredrik Pedersen
 * @version 1.0
 * @since 13/11/2021 at 13:31
 */

@Retention(RetentionPolicy.RUNTIME)
@PreAuthorize("hasAnyAuthority(\"" + ADMIN_ORDER_READ + "\", \"" + CUSTOMER_ORDER_READ + "\")")
public @interface BeerOrderReadPermissionV2 {
}