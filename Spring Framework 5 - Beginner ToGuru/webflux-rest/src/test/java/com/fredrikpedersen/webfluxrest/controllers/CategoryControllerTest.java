package com.fredrikpedersen.webfluxrest.controllers;

import com.fredrikpedersen.webfluxrest.domain.Category;
import com.fredrikpedersen.webfluxrest.repositories.CategoryRepository;
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
 * @since 15/07/2021 at 17:30
 */

class CategoryControllerTest {

    private final String BASE_URL = URLs.CATEGORY_BASE_URL;

    @Mock
    private CategoryRepository categoryRepository;

    private WebTestClient webTestClient;
    private CategoryController categoryController;


    @BeforeEach
    public void setUp() throws Exception {
        MockitoAnnotations.openMocks(this);

        categoryController = new CategoryController(categoryRepository);
        webTestClient = WebTestClient.bindToController(categoryController).build();
    }

    @Test
    public void list() {

        //given
        given(categoryRepository.findAll()).willReturn(Flux.just(
                        Category.builder().description("Sci-fi").build(),
                        Category.builder().description("Fantasy").build()
        ));

        //when/then
        webTestClient.get()
                .uri(BASE_URL)
                .exchange()
                .expectBodyList(Category.class)
                .hasSize(2);
    }

    @Test
    public void getById() {

        //given
        given(categoryRepository.findById("someid")).willReturn(Mono.just(Category.builder().description("Sci-fi").build()));

        //when/then
        webTestClient.get()
                .uri(BASE_URL + "someid")
                .exchange()
                .expectBody(Category.class);

    }

    @Test
    public void testCreateCateogry() {

        //given
        given(categoryRepository.saveAll(any(Publisher.class))).willReturn(Flux.just(
                Category.builder().description("Fantasy").build()
        ));

        final Mono<Category> toSaveMono = Mono.just(Category.builder().description("Some description").build());

        webTestClient.post()
                .uri(BASE_URL)
                .body(toSaveMono, Category.class)
                .exchange()
                .expectStatus().isCreated();
    }

}