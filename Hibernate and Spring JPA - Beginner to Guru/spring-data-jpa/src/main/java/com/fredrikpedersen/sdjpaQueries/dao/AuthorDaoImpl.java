package com.fredrikpedersen.sdjpaQueries.dao;

import com.fredrikpedersen.sdjpaQueries.domain.Author;
import com.fredrikpedersen.sdjpaQueries.repositories.AuthorRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import javax.transaction.Transactional;


@Component
@RequiredArgsConstructor
public class AuthorDaoImpl implements AuthorDao {

    private final AuthorRepository repository;

    @Override
    public Author findById(final Long id) {
        return repository.getById(id);
    }

    @Override
    public Author findByName(final String firstName, final String lastName) {
        return repository.findAuthorByFirstNameAndLastName(firstName, lastName);
    }

    @Override
    public Author save(final Author author) {
        return repository.save(author);
    }

    @Override
    @Transactional
    public Author update(final Author author) {
        final Author foundAuthor = repository.getById(author.getId());
        foundAuthor.setFirstName(author.getFirstName());
        foundAuthor.setLastName(author.getLastName());

        return repository.save(foundAuthor);
    }

    @Override
    public void deleteById(final Long id) {
        repository.deleteById(id);
    }
}
