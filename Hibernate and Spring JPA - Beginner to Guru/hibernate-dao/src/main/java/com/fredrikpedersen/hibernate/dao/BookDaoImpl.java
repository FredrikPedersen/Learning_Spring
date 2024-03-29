package com.fredrikpedersen.hibernate.dao;

import com.fredrikpedersen.hibernate.domain.Book;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.TypedQuery;
import java.util.List;

@Component
@RequiredArgsConstructor
public class BookDaoImpl implements BookDao {
    
    private final EntityManagerFactory emf;

    @Override
    public List<Book> findAll() {
        final EntityManager entityManager = getEntityManager();

        try {
            final TypedQuery<Book> query = entityManager.createNamedQuery("book_find_all", Book.class);
            return query.getResultList();
        } finally {
            entityManager.close();
        }
    }

    @Override
    public List<Book> findAll(final int pageSize, final int offset) {
        return null;
    }

    @Override
    public List<Book> findAll(final Pageable pageable) {
        final EntityManager entityManager = getEntityManager();

        try {
            final TypedQuery<Book> query = entityManager.createQuery("SELECT b FROM Book b", Book.class);
            query.setFirstResult(Math.toIntExact(pageable.getOffset()));
            query.setMaxResults(pageable.getPageSize());

            return query.getResultList();

        } finally {
            entityManager.close();
        }
    }

    @Override
    public List<Book> findAllSortByTitle(final Pageable pageable) {
        final EntityManager entityManager = getEntityManager();
        final String hql = "SELECT b FROM Book b ORDER BY b.title "
                + pageable.getSort().getOrderFor("title").getDirection().name();

        try {
            final TypedQuery<Book> query = entityManager.createQuery(hql, Book.class);
            query.setFirstResult(Math.toIntExact(pageable.getOffset()));
            query.setMaxResults(pageable.getPageSize());

            return query.getResultList();

        } finally {
            entityManager.close();
        }
    }

    @Override
    public Book findByISBN(final String isbn) {
        final EntityManager entityManager = getEntityManager();

        try {
            final TypedQuery<Book> query = entityManager.createQuery("SELECT b FROM Book b WHERE b.isbn = :isbn", Book.class);
            query.setParameter("isbn", isbn);

            return query.getSingleResult();

        } finally {
            entityManager.close();
        }
    }

    @Override
    public Book findById(final Long id) {
        final EntityManager entityManager = getEntityManager();
        final Book book = getEntityManager().find(Book.class, id);
        entityManager.close();
        
        return book;
    }

    @Override
    public Book findByTitle(final String title) {
        final EntityManager entityManager = getEntityManager();

        try {
            final TypedQuery<Book> query = entityManager.createNamedQuery("book_find_by_title", Book.class);
            query.setParameter("title", title);

            return query.getSingleResult();
        } finally {
            entityManager.close();
        }
    }

    @Override
    public Book save(final Book book) {
        final EntityManager entityManager = getEntityManager();
        entityManager.getTransaction().begin();
        entityManager.persist(book);
        entityManager.flush();
        entityManager.getTransaction().commit();
        entityManager.close();
        
        return book;
    }

    @Override
    public Book update(final Book book) {
        final EntityManager entityManager = getEntityManager();
        entityManager.getTransaction().begin();
        entityManager.merge(book);
        entityManager.flush();
        entityManager.clear();
        
        final Book savedBook = entityManager.find(Book.class, book.getId());
        entityManager.getTransaction().commit();
        entityManager.close();
        
        return savedBook;
    }

    @Override
    public void deleteById(final Long id) {
        final EntityManager entityManager = getEntityManager();
        
        entityManager.getTransaction().begin();
        final Book book = entityManager.find(Book.class, id);
        
        entityManager.remove(book);
        entityManager.getTransaction().commit();
        entityManager.close();
    }

    private EntityManager getEntityManager(){
        return emf.createEntityManager();
    }
}
