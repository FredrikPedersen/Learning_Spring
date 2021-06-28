package com.fredrikpedersen.brewery.repositories.security;

import com.fredrikpedersen.brewery.domain.security.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

/**
 * @author Fredrik Pedersen
 * @version 1.0
 * @since 28/06/2021 at 09:45
 */
public interface UserRepository extends JpaRepository<User, Integer> {

    Optional<User> findByUsername(String username);
}
