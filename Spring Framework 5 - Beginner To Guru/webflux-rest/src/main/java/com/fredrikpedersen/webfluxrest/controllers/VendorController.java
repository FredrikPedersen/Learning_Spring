package com.fredrikpedersen.webfluxrest.controllers;

import com.fredrikpedersen.webfluxrest.domain.Vendor;
import com.fredrikpedersen.webfluxrest.repositories.VendorRepository;
import lombok.RequiredArgsConstructor;
import org.reactivestreams.Publisher;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
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

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    protected Mono<Void> create(@RequestBody final Publisher<Vendor> vendorStream) {
        return vendorRepository.saveAll(vendorStream).then();
    }

    @PutMapping("{id}")
    protected Mono<Vendor> update(@PathVariable final String id, @RequestBody final Vendor vendor) {
        vendor.setId(id);
        return vendorRepository.save(vendor);
    }

}
