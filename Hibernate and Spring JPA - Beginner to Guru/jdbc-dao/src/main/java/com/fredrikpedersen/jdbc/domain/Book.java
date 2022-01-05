package com.fredrikpedersen.jdbc.domain;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.Transient;

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

    @Transient
    private Author author;

    @Builder
    public Book(final String title, final String isbn, final String publisher, final Author author) {
        this.title = title;
        this.isbn = isbn;
        this.publisher = publisher;
        this.author = author;
    }
}

