package com.fredrikpedersen.courseproject;

import com.fredrikpedersen.courseproject.domain.Book;
import com.fredrikpedersen.courseproject.repositories.BookRepository;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.test.context.ActiveProfiles;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@DataJpaTest
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@ComponentScan(basePackages = {"com.fredrikpedersen.courseproject.bootstrap"})
public class SpringBootJpaTestSlice {

    @Autowired
    private BookRepository bookRepository;

    @Test
    @Order(1)
    void testJpaTestSplice() {

        //given
        final long countBefore = bookRepository.count();

        //when
        bookRepository.save(new Book("My Book", "1235555", "Self", null));

        //then
        final long countAfter = bookRepository.count();
        assertThat(countBefore).isLessThan(countAfter);
    }
}
