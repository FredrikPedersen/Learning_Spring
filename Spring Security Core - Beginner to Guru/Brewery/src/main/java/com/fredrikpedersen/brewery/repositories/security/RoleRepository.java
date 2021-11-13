package com.fredrikpedersen.brewery.repositories.security;

import com.fredrikpedersen.brewery.domain.security.Role;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

/**
 * @author Fredrik Pedersen
 * @version 1.0
 * @since 04/08/2021 at 17:11
 */
public interface RoleRepository extends JpaRepository<Role, Integer> {
    Optional<Role> findByName(String name);
}
