package com.fredrikpedersen.sdjpaQueries.dao;

import com.fredrikpedersen.sdjpaQueries.domain.Book;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class BookDaoImpl implements BookDao {

    @Override
    public Book findById(final Long id) {
        return null;
    }

    @Override
    public Book findByTitle(final String title) {
        return null;
    }

    @Override
    public Book save(final Book book) {
        return null;
    }

    @Override
    public Book update(final Book book) {
        return null;
    }

    @Override
    public boolean deleteById(final Long id) {
        return false;
    }
}
