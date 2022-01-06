package com.fredrikpedersen.hibernate.dao;

import com.fredrikpedersen.hibernate.domain.Author;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import java.util.List;


@Component
@RequiredArgsConstructor
public class AuthorDaoImpl implements AuthorDao {

    private final EntityManagerFactory emf;

    @Override
    public List<Author> findAllWithLastNameLike(final String lastName) {
        final EntityManager entityManager = getEntityManager();

        try {
            final Query query = entityManager.createQuery("SELECT a from Author a WHERE a.lastName like :last_name");
            query.setParameter("last_name", lastName + "%");

            return query.getResultList();

        } finally {
            entityManager.close();
        }
    }

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
        final EntityManager entityManager = getEntityManager();

        entityManager.getTransaction().begin();
        entityManager.persist(author);
        entityManager.flush();
        entityManager.getTransaction().commit();

        return author;
    }

    @Override
    public Author update(final Author author) {
        final EntityManager entityManager = getEntityManager();

        entityManager.joinTransaction();
        entityManager.merge(author);
        entityManager.flush();
        entityManager.clear();
        entityManager.getTransaction().commit();

        return entityManager.find(Author.class, author.getId());
    }

    @Override
    public void deleteById(final Long id) {
        final EntityManager entityManager = getEntityManager();

        entityManager.getTransaction().begin();
        final Author author = entityManager.find(Author.class, id);

        entityManager.remove(author);
        entityManager.flush();
        entityManager.getTransaction().commit();

    }

    private EntityManager getEntityManager() {
        return emf.createEntityManager();
    }
}