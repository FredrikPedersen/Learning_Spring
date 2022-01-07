package com.fredrikpedersen.sdjpaQueries.dao;

import com.fredrikpedersen.sdjpaQueries.domain.Book;
import com.fredrikpedersen.sdjpaQueries.repositories.AuthorRepository;
import com.fredrikpedersen.sdjpaQueries.repositories.BookRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import javax.persistence.EntityNotFoundException;
import javax.transaction.Transactional;

@Component
@RequiredArgsConstructor
public class BookDaoImpl implements BookDao {

    private final BookRepository repository;

    @Override
    public Book findById(final Long id) {
        return repository.getById(id);
    }

    @Override
    public Book findByTitle(final String title) {
        return repository.findByTitle(title)
                .orElseThrow(EntityNotFoundException::new);
    }

    @Override
    public Book save(final Book book) {
        return repository.save(book);
    }

    @Override
    @Transactional
    public Book update(final Book book) {
        final Book foundBook = repository.getById(book.getId());
        foundBook.setTitle(book.getTitle());
        foundBook.setIsbn(book.getIsbn());
        foundBook.setPublisher(book.getPublisher());
        foundBook.setAuthorId(book.getAuthorId());

        return repository.save(book);
    }

    @Override
    public void deleteById(final Long id) {
        repository.deleteById(id);
    }
}
