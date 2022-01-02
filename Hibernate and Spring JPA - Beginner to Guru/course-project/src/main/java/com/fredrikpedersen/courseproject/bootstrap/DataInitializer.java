package com.fredrikpedersen.courseproject.bootstrap;

import com.fredrikpedersen.courseproject.repositories.BookRepository;
import com.fredrikpedersen.courseproject.domain.Book;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
@Profile({"local", "default"})
public class DataInitializer implements CommandLineRunner {

    private final BookRepository bookRepository;

    @Override
    public void run(String... args) throws Exception {
        bookRepository.deleteAll();

        final List<Book> books = List.of(
                new Book("Domain Driven Design", "123", "RandomHouse"),
                new Book("Spring In Action", "234234", "Oriely")
        );

        bookRepository.saveAll(books);

        bookRepository.findAll().forEach(book -> {
            System.out.println("Book Id: " + book.getId());
            System.out.println("Book Title: " + book.getTitle());
        });

    }
}
