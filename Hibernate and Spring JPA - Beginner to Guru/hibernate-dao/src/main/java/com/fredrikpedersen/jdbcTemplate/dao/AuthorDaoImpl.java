package com.fredrikpedersen.jdbcTemplate.dao;

import com.fredrikpedersen.jdbcTemplate.domain.Author;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.TypedQuery;


@Component
@RequiredArgsConstructor
public class AuthorDaoImpl implements AuthorDao {

    private final EntityManagerFactory emf;

    @Override
    public Author findById(final Long id) {
        return getEntityManager().find(Author.class, id);
    }

    @Override
    public Author findByName(final String firstName, final String lastName) {
        final TypedQuery<Author> query = getEntityManager().createQuery(
                "SELECT a FROM Author a WHERE a.firstName = :first_name and a.lastName = :last_name",
                Author.class);

        query.setParameter("first_name", firstName);
        query.setParameter("last_name", lastName);

        return query.getSingleResult();
    }

    @Override
    public Author save(final Author author) {
        return null;
    }

    @Override
    public Author update(final Author author) {
        return null;
    }

    @Override
    public boolean deleteById(final Long id) {
        return false;
    }

    private EntityManager getEntityManager() {
        return emf.createEntityManager();
    }
}
