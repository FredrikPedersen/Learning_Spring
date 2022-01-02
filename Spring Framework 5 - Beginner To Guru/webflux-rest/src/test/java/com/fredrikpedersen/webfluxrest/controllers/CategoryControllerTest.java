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
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.verify;

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
    public void testCreateCategory() {

        //given
        given(categoryRepository.saveAll(any(Publisher.class))).willReturn(Flux.just(
                Category.builder().description("Fantasy").build()
        ));

        final Mono<Category> toSaveMono = Mono.just(Category.builder().description("Some description").build());

        //when/then
        webTestClient.post()
                .uri(BASE_URL)
                .body(toSaveMono, Category.class)
                .exchange()
                .expectStatus().isCreated();
    }

    @Test
    public void testUpdate() {
        //given
        given(categoryRepository.save(any(Category.class))).willReturn(Mono.just(Category.builder().build()));
        final Mono<Category> catToUpdateMono = Mono.just(Category.builder().description("Fantasy").build());

        webTestClient.put()
                .uri(BASE_URL + "someId")
                .body(catToUpdateMono, Category.class)
                .exchange()
                .expectStatus()
                .isOk();
    }

    @Test
    public void testPatchWithChanges() {

        //given
        given(categoryRepository.findById(anyString())).willReturn(Mono.just(Category.builder().description("Sci-Fi").build()));
        given(categoryRepository.save(any(Category.class))).willReturn(Mono.just(Category.builder().description("Fantasy").build()));
        final Mono<Category> catToUpdateMono = Mono.just(Category.builder().description("Fantasy").build());

        //when/then
        webTestClient.patch()
                .uri(BASE_URL + "someId")
                .body(catToUpdateMono, Category.class)
                .exchange()
                .expectStatus()
                .isOk();

        verify(categoryRepository).save(any());
    }

    @Test
    public void testPatchNoChanges() {

        //given
        given(categoryRepository.findById(anyString())).willReturn(Mono.just(Category.builder().description("Fantasy").build()));
        final Mono<Category> catToUpdateMono = Mono.just(Category.builder().description("Fantasy").build());

        //when/then
        webTestClient.patch()
                .uri(BASE_URL + "someId")
                .body(catToUpdateMono, Category.class)
                .exchange()
                .expectStatus()
                .isOk();

        verify(categoryRepository, never()).save(any());
    }
}