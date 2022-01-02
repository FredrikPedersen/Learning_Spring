package com.fredrikpedersen.courseproject.domain;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@Entity
@NoArgsConstructor
public class Book {

    @Id
    @Column(columnDefinition = "serial")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;
    private String isbn;
    private String publisher;

    public Book(final String title, final String isbn, final String publisher) {
        this.title = title;
        this.isbn = isbn;
        this.publisher = publisher;
    }
}
