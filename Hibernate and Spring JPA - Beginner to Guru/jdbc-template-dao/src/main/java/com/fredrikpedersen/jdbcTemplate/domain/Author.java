package com.fredrikpedersen.jdbcTemplate.domain;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.Transient;
import java.util.List;

@Getter
@Setter
@Entity
@NoArgsConstructor
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
public class Author extends IdentityEntity {

    private String firstName;
    private String lastName;

    @Transient
    private List<Book> boooks;

    @Builder
    public Author(final String firstName, final String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }
}
