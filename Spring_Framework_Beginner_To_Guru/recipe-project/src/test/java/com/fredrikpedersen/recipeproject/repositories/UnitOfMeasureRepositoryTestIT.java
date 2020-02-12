package com.fredrikpedersen.recipeproject.repositories;

import com.fredrikpedersen.recipeproject.domain.UnitOfMeasure;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author Fredrik Pedersen
 * @version 1.0
 * @since 12/02/2020 at 08:27
 */

@ExtendWith(SpringExtension.class)
@DataJpaTest
class UnitOfMeasureRepositoryTestIT {

    @Autowired
    UnitOfMeasureRepository unitOfMeasureRepository;

    @BeforeEach
    void setUp() {
    }

    @Test
    @DirtiesContext //Makes Spring Context have to reload after this test.
    void findByDescription() {
        Optional<UnitOfMeasure> uomOptional = unitOfMeasureRepository.findByDescription("Milliliter");
        assertEquals("Milliliter", uomOptional.get().getDescription());
    }

    //The first test takes around 218ms to run, while this will take 7ms, that is due to Spring Context still being available
    @Test
    void findByDescriptionCenti() {
        Optional<UnitOfMeasure> uomOptional = unitOfMeasureRepository.findByDescription("Centiliter");
        assertEquals("Centiliter", uomOptional.get().getDescription());
    }
}