package com.fredrikpedersen.webfluxrest.controllers;

import com.fredrikpedersen.webfluxrest.domain.Category;
import com.fredrikpedersen.webfluxrest.repositories.CategoryRepository;
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
 * @since 15/07/2021 at 17:20
 */

@RestController
@RequiredArgsConstructor
@RequestMapping(URLs.CATEGORY_BASE_URL)
public class CategoryController {

    private final CategoryRepository categoryRepository;

    @GetMapping
    public Flux<Category> findAll() {
        return categoryRepository.findAll();
    }

    @GetMapping("{id}")
    public Mono<Category> getById(@PathVariable final String id) {
        return categoryRepository.findById(id);
    }
}
