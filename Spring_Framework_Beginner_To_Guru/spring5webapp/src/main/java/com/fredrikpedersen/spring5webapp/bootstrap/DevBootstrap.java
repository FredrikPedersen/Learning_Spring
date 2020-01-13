package com.fredrikpedersen.spring5webapp.bootstrap;

import com.fredrikpedersen.spring5webapp.model.Author;
import com.fredrikpedersen.spring5webapp.model.Book;
import com.fredrikpedersen.spring5webapp.repositories.AuthorRepository;
import com.fredrikpedersen.spring5webapp.repositories.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;


@Component
public class DevBootstrap implements ApplicationListener<ContextRefreshedEvent> {

    private AuthorRepository authorRepository;
    private BookRepository bookRepository;

    public DevBootstrap(AuthorRepository authorRepository, BookRepository bookRepository) {
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
    }

    @Override
    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {
        initData();
    }

    private void initData() {

        Author eric = new Author("Eric", "Evans");
        Book theBookening = new Book("The Bookening", "1234", "Harper Collins");
        eric.getBooks().add(theBookening);
        theBookening.getAuthors().add(eric);

        authorRepository.save(eric);
        bookRepository.save(theBookening);

        Author rod = new Author("Rod", "Johnson");
        Book harryPlotter = new Book("Harry Plotter And the Revenge of the Graphs", "4321", "Worx");
        rod.getBooks().add(harryPlotter);

        authorRepository.save(rod);
        bookRepository.save(harryPlotter);
    }
}
