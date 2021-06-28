package com.fredrikpedersen.brewery.repositories.security;

import com.fredrikpedersen.brewery.domain.security.Authority;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author Fredrik Pedersen
 * @version 1.0
 * @since 28/06/2021 at 09:45
 */
public interface AuthorityRepository extends JpaRepository<Authority, Integer> {
}
