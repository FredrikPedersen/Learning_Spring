package com.fredrikpedersen.brewery.bootstrap;

import com.fredrikpedersen.brewery.domain.security.Authority;
import com.fredrikpedersen.brewery.domain.security.User;
import com.fredrikpedersen.brewery.repositories.security.AuthorityRepository;
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
        final Set<Authority> admin = new HashSet<>(Collections.singletonList(authorityRepository.save(Authority.builder().permission("ROLE_ADMIN").build())));
        final Set<Authority> user = new HashSet<>(Collections.singletonList(authorityRepository.save(Authority.builder().permission("ROLE_USER").build())));
        final Set<Authority> customer = new HashSet<>(Collections.singletonList(authorityRepository.save(Authority.builder().permission("ROLE_CUSTOMER").build())));

        userRepository.save(User.builder()
                .username("admin")
                .password(passwordEncoder.encode("password"))
                .authorities(admin)
                .build());

        userRepository.save(User.builder()
                .username("user")
                .password(passwordEncoder.encode("password"))
                .authorities(user)
                .build());

        userRepository.save(User.builder()
                .username("customer")
                .password(passwordEncoder.encode("password"))
                .authorities(customer)
                .build());

        log.info("Done seeding user data!");
    }
}
