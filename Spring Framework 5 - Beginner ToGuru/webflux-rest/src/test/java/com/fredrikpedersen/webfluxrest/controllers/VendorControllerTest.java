package com.fredrikpedersen.webfluxrest.controllers;

import com.fredrikpedersen.webfluxrest.domain.Vendor;
import com.fredrikpedersen.webfluxrest.repositories.VendorRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.reactivestreams.Publisher;
import org.springframework.test.web.reactive.server.WebTestClient;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.given;

/**
 * @author Fredrik Pedersen
 * @version 1.0
 * @since 15/07/2021 at 17:37
 */
class VendorControllerTest {

    private final String BASE_URL = URLs.VENDOR_BASE_URL;

    @Mock
    private VendorRepository vendorRepository;

    private WebTestClient webTestClient;
    private VendorController vendorController;


    @BeforeEach
    public void setUp() throws Exception {
        MockitoAnnotations.openMocks(this);

        vendorController = new VendorController(vendorRepository);
        webTestClient = WebTestClient.bindToController(vendorController).build();
    }

    @Test
    public void list() {

        //given
        given(vendorRepository.findAll()).willReturn(Flux.just(
                Vendor.builder().firstname("Fredrik").lastname("Pedersen").build(),
                Vendor.builder().firstname("Fredrik").lastname("Pedersen").build()
        ));

        //when/then
        webTestClient.get()
                .uri(BASE_URL)
                .exchange()
                .expectBodyList(Vendor.class)
                .hasSize(2);
    }

    @Test
    public void getById() {

        //given
        given(vendorRepository.findById("someid")).willReturn(Mono.just(Vendor.builder().firstname("Fredrik").lastname("Pedersen").build()));

        //when/then
        webTestClient.get()
                .uri(BASE_URL + "someid")
                .exchange()
                .expectBody(Vendor.class);

    }

    @Test
    public void testCreateVendor() {

        //given
        given(vendorRepository.saveAll(any(Publisher.class))).willReturn(Flux.just(Vendor.builder().build()));
        final Mono<Vendor> vendorToSaveMono = Mono.just(Vendor.builder().firstname("Fredrik").lastname("Pedersen").build());

        //when/then
        webTestClient.post()
                .uri(BASE_URL)
                .body(vendorToSaveMono, Vendor.class)
                .exchange()
                .expectStatus()
                .isCreated();
    }
}