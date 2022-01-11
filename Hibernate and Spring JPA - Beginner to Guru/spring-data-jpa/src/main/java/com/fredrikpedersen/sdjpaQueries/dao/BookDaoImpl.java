package com.fredrikpedersen.sdjpaQueries.dao;

import com.fredrikpedersen.sdjpaQueries.domain.Book;
import com.fredrikpedersen.sdjpaQueries.repositories.AuthorRepository;
import com.fredrikpedersen.sdjpaQueries.repositories.BookRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;

import javax.persistence.EntityNotFoundException;
import javax.transaction.Transactional;
import java.util.List;

@Component
@RequiredArgsConstructor
public class BookDaoImpl implements BookDao {

    private final BookRepository repository;

    @Override
    public List<Book> findAll() {
        return repository.findAll();
    }

    @Override
    public List<Book> findAllSortByTitle(final Pageable pageable) {
        //Sorting is applied automatically when a Pageable with a sorting property is passed to the method
        final Page<Book> bookPage = repository.findAll(pageable);

        return bookPage.getContent();
    }

    @Override
    public List<Book> findAll(final Pageable pageable) {
        return repository.findAll(pageable).getContent();
    }

    @Override
    public List<Book> findAll(final int pageSize, int offset) {
        Pageable pageable = PageRequest.ofSize(pageSize);

        if (offset > 0) {
            pageable = pageable.withPage(offset / pageSize);
        } else {
            pageable = pageable.withPage(0);
        }

        return this.findAll(pageable);
    }

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
