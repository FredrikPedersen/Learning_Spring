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
        final Authority admin = authorityRepository.save(Authority.builder().role("ADMIN").build());
        final Authority userRole = authorityRepository.save(Authority.builder().role("USER").build());
        final Authority customer = authorityRepository.save(Authority.builder().role("CUSTOMER").build());

        userRepository.save(User.builder()
                .username("admin")
                .password(passwordEncoder.encode("admin"))
                .authority(admin)
                .build());

        userRepository.save(User.builder()
                .username("user")
                .password(passwordEncoder.encode("pw"))
                .authority(userRole)
                .build());

        userRepository.save(User.builder()
                .username("fredrik")
                .password(passwordEncoder.encode("123"))
                .authority(customer)
                .build());

        log.info("Done seeding user data!");
    }
}
