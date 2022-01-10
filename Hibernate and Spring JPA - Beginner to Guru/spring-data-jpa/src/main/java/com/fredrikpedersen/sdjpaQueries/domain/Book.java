package com.fredrikpedersen.sdjpaQueries.domain;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.NamedQuery;

@NamedQuery(name = "Book.jpaNamed", query = "FROM Book b WHERE b.title = :title")

@Getter
@Setter
@Entity
@NoArgsConstructor
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
public class Book extends IdentityEntity {

    private String title;
    private String isbn;
    private String publisher;
    private Long authorId;

    @Builder
    public Book(final String title, final String isbn, final String publisher, final Long authorId) {
        this.title = title;
        this.isbn = isbn;
        this.publisher = publisher;
        this.authorId = authorId;
    }
}

