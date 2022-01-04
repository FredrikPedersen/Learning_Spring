package com.fredrikpedersen.courseproject.bootstrap;

import com.fredrikpedersen.courseproject.repositories.BookRepository;
import com.fredrikpedersen.courseproject.domain.Book;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

import java.util.List;

@Slf4j
@Component
@RequiredArgsConstructor
@Profile({"local", "default"})
public class DataInitializer implements CommandLineRunner {

    private final BookRepository bookRepository;

    @Override
    public void run(String... args) throws Exception {
        if (bookRepository.count() == 0) {
            log.info("No books found, seeding data");
            final List<Book> books = List.of(
                    new Book("Domain Driven Design", "123", "RandomHouse", null),
                    new Book("Spring In Action", "234234", "Oriely", null)
            );

            bookRepository.saveAll(books);
        }

        bookRepository.findAll().forEach(System.out::println);
    }
}
