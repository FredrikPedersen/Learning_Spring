package com.fredrikpedersen.brewery.security.permissions;

import org.springframework.security.access.prepost.PreAuthorize;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

import static com.fredrikpedersen.brewery.security.permissions.Authorities.BEER_CREATE;

/**
 * @author Fredrik Pedersen
 * @version 1.0
 * @since 09/08/2021 at 17:43
 */

@Retention(RetentionPolicy.RUNTIME)
@PreAuthorize("hasAuthority(\"" + BEER_CREATE + "\")")
public @interface BeerCreatePermission {
}
