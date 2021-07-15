package com.fredrikpedersen.webfluxrest.bootstrap;

import com.fredrikpedersen.webfluxrest.domain.Category;
import com.fredrikpedersen.webfluxrest.domain.Vendor;
import com.fredrikpedersen.webfluxrest.repository.CategoryRepository;
import com.fredrikpedersen.webfluxrest.repository.VendorRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;

import java.util.List;

import static java.util.Arrays.asList;

/**
 * @author Fredrik Pedersen
 * @version 1.0
 * @since 15/07/2021 at 17:07
 */

@Slf4j
@RequiredArgsConstructor
public class DataSeeder implements CommandLineRunner {

    private final CategoryRepository categoryRepository;
    private final VendorRepository vendorRepository;

    @Override
    public void run(String... args) {

        log.info("Seeding data...");

        seedCategories();
        seedVendors();

        log.info("Done seeding data!");
    }

    private void seedCategories() {

        final List<Category> categories = asList(
                Category.builder().description("Fantasy").build(),
                Category.builder().description("Sci-Fi").build(),
                Category.builder().description("Simulation").build(),
                Category.builder().description("Strategy").build()
        );

        categories.forEach(category -> categoryRepository.save(category).block());
    }

    private void seedVendors() {

        final List<Vendor> vendors = asList(
                Vendor.builder().firstname("Fredrik").lastname("Pedersen").build(),
                Vendor.builder().firstname("Thomas").lastname("Kristiansen").build(),
                Vendor.builder().firstname("Joakim").lastname("Standal").build(),
                Vendor.builder().firstname("Michael").lastname("Thoresen").build()
        );

        vendors.forEach(category -> vendorRepository.save(category).block());
    }
}
