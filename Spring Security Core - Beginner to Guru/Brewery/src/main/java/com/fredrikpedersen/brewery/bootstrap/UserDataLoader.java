package com.fredrikpedersen.brewery.bootstrap;

import com.fredrikpedersen.brewery.domain.security.Authority;
import com.fredrikpedersen.brewery.domain.security.Role;
import com.fredrikpedersen.brewery.domain.security.User;
import com.fredrikpedersen.brewery.repositories.security.AuthorityRepository;
import com.fredrikpedersen.brewery.repositories.security.RoleRepository;
import com.fredrikpedersen.brewery.repositories.security.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

/**
 * @author Fredrik Pedersen
 * @version 1.0
 * @since 28/06/2021 at 09:48
 */

@Slf4j
@Component
@RequiredArgsConstructor
public class UserDataLoader implements CommandLineRunner {

    private final AuthorityRepository authorityRepository;
    private final RoleRepository roleRepository;
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    @Override
    public void run(String... args) {
        if (authorityRepository.count() == 0) {
            seedSecurityData();
        }
    }

    private void seedSecurityData() {
        log.info("Seeding user data...");

        //Beer authorities
        final Authority createBeer = authorityRepository.save(Authority.builder().permission("beer.create").build());
        final Authority updateBeer = authorityRepository.save(Authority.builder().permission("beer.update").build());
        final Authority readBeer = authorityRepository.save(Authority.builder().permission("beer.read").build());
        final Authority deleteBeer = authorityRepository.save(Authority.builder().permission("beer.delete").build());

        //Customer authorities
        final Authority createCustomer = authorityRepository.save(Authority.builder().permission("customer.create").build());
        final Authority readCustomer = authorityRepository.save(Authority.builder().permission("customer.read").build());
        final Authority updateCustomer = authorityRepository.save(Authority.builder().permission("customer.update").build());
        final Authority deleteCustomer = authorityRepository.save(Authority.builder().permission("customer.delete").build());

        //Brewery authorities
        final Authority createBrewery = authorityRepository.save(Authority.builder().permission("brewery.create").build());
        final Authority readBrewery = authorityRepository.save(Authority.builder().permission("brewery.read").build());
        final Authority updateBrewery = authorityRepository.save(Authority.builder().permission("brewery.update").build());
        final Authority deleteBrewery = authorityRepository.save(Authority.builder().permission("brewery.delete").build());

        //Roles
        final Role adminRole = roleRepository.save(Role.builder().name("ADMIN").build());
        final Role customerRole = roleRepository.save(Role.builder().name("CUSTOMER").build());
        final Role userRole = roleRepository.save(Role.builder().name("USER").build());

        adminRole.setAuthorities(new HashSet<>(Set.of(createBeer, updateBeer, readBeer, deleteBeer, createCustomer, readCustomer, updateCustomer, deleteCustomer, createBrewery, readBrewery, updateBrewery, deleteBrewery)));
        customerRole.setAuthorities(new HashSet<>(Set.of(readBeer, readCustomer, readBrewery)));
        userRole.setAuthorities(new HashSet<>(Set.of(readBeer)));

        roleRepository.saveAll(Arrays.asList(adminRole, customerRole, userRole));

        userRepository.save(User.builder()
                .username("admin")
                .password(passwordEncoder.encode("password"))
                .role(adminRole)
                .build());

        userRepository.save(User.builder()
                .username("user")
                .password(passwordEncoder.encode("password"))
                .role(userRole)
                .build());

        userRepository.save(User.builder()
                .username("customer")
                .password(passwordEncoder.encode("password"))
                .role(customerRole)
                .build());

        log.info("Done seeding user data!");
    }
}
