package com.fredrikpedersen.courseproject;

import com.fredrikpedersen.courseproject.repositories.BookRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@SpringBootTest
@ActiveProfiles("local")
class SdjpaIntroApplicationTests {

    @Autowired
    private BookRepository bookRepository;

    @Test
    void testBookRepository() {
        final long count = bookRepository.count();

        assertThat(count).isGreaterThan(0);
    }

    @Test
    void contextLoads() {
    }

}
