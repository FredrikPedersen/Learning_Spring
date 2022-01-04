package com.fredrikpedersen.courseproject.domain;

import lombok.*;

import javax.persistence.Entity;

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

    public Book(final String title, final String isbn, final String publisher) {
        this.title = title;
        this.isbn = isbn;
        this.publisher = publisher;
    }
}
