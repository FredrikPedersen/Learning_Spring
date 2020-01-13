package com.fredrikpedersen.spring5webapp.bootstrap;

import com.fredrikpedersen.spring5webapp.model.Author;
import com.fredrikpedersen.spring5webapp.model.Book;
import com.fredrikpedersen.spring5webapp.model.Publisher;
import com.fredrikpedersen.spring5webapp.repositories.AuthorRepository;
import com.fredrikpedersen.spring5webapp.repositories.BookRepository;
import com.fredrikpedersen.spring5webapp.repositories.PublisherRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;


@Component
public class DevBootstrap implements ApplicationListener<ContextRefreshedEvent> {

    private AuthorRepository authorRepository;
    private PublisherRepository publisherRepository;
    private BookRepository bookRepository;

    public DevBootstrap(AuthorRepository authorRepository, PublisherRepository publisherRepository, BookRepository bookRepository) {
        this.authorRepository = authorRepository;
        this.publisherRepository = publisherRepository;
        this.bookRepository = bookRepository;
    }

    @Override
    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {
        initData();
    }

    private void initData() {

        Author eric = new Author("Eric", "Evans");
        Publisher harper = new Publisher("Harper Collins", "Roadway 123");
        Book theBookening = new Book("The Bookening", "1234", harper);
        eric.getBooks().add(theBookening);
        theBookening.getAuthors().add(eric);

        authorRepository.save(eric);
        publisherRepository.save(harper);
        bookRepository.save(theBookening);

        Author rod = new Author("Rod", "Johnson");
        Publisher worx = new Publisher("Worx", "Streetplace 321");
        Book harryPlotter = new Book("Harry Plotter And the Revenge of the Graphs", "4321", worx);
        rod.getBooks().add(harryPlotter);

        authorRepository.save(rod);
        publisherRepository.save(worx);
        bookRepository.save(harryPlotter);
    }
}
