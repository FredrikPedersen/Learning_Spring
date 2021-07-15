package com.fredrikpedersen.webfluxrest.controllers;

import com.fredrikpedersen.webfluxrest.domain.Vendor;
import com.fredrikpedersen.webfluxrest.repositories.VendorRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

/**
 * @author Fredrik Pedersen
 * @version 1.0
 * @since 15/07/2021 at 17:36
 */

@RestController
@RequiredArgsConstructor
@RequestMapping(URLs.VENDOR_BASE_URL)
public class VendorController {

    private final VendorRepository vendorRepository;

    @GetMapping
    public Flux<Vendor> findAll() {
        return vendorRepository.findAll();
    }

    @GetMapping("{id}")
    public Mono<Vendor> getById(@PathVariable final String id) {
        return vendorRepository.findById(id);
    }
}
