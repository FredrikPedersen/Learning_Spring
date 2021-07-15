package com.fredrikpedersen.webfluxrest.controllers;

import com.fredrikpedersen.webfluxrest.domain.Category;
import com.fredrikpedersen.webfluxrest.repositories.CategoryRepository;
import lombok.RequiredArgsConstructor;
import org.reactivestreams.Publisher;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

/**
 * @author Fredrik Pedersen
 * @version 1.0
 * @since 15/07/2021 at 17:20
 */

@RestController
@RequiredArgsConstructor
@RequestMapping(URLs.CATEGORY_BASE_URL)
public class CategoryController {

    private final CategoryRepository categoryRepository;

    @GetMapping
    protected Flux<Category> findAll() {
        return categoryRepository.findAll();
    }

    @GetMapping("/{id}")
    protected Mono<Category> getById(@PathVariable final String id) {
        return categoryRepository.findById(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    protected Mono<Void> create(@RequestBody final Publisher<Category> categoryStream) {
        return categoryRepository.saveAll(categoryStream).then();
    }
}
