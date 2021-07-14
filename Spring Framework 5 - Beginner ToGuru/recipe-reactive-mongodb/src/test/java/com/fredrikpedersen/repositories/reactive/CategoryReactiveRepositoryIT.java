package com.fredrikpedersen.repositories.reactive;

import com.fredrikpedersen.domain.Category;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.data.mongo.DataMongoTest;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author Fredrik Pedersen
 * @version 1.0
 * @since 14/07/2021 at 09:43
 */

@DataMongoTest
class CategoryReactiveRepositoryIT {

    @Autowired
    CategoryReactiveRepository categoryReactiveRepository;

    @BeforeEach
    public void setUp() {
        categoryReactiveRepository.deleteAll().block();
    }

    @Test
    public void testSave() {
        final Category category = new Category();
        category.setDescription("Foo");

        categoryReactiveRepository.save(category).block();

        final Long count = categoryReactiveRepository.count().block();

        assertEquals(Long.valueOf(1L), count);
    }

    @Test
    public void testFindByDescription() {
        final Category category = new Category();
        category.setDescription("Foo");

        categoryReactiveRepository.save(category).then().block();

        final Category fetchedCat = categoryReactiveRepository.findByDescription("Foo").block();

        assertNotNull(fetchedCat.getId());
    }

}