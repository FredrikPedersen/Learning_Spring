package com.fredrikpedersen.hibernate.domain;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;

@NamedQueries({
        @NamedQuery(name = "author_find_all", query = "FROM Author"),
        @NamedQuery(name = "author_find_by_name", query = "FROM Author a WHERE a.firstName = :first_name and a.lastName = :last_name")
})


@Getter
@Setter
@Entity
@NoArgsConstructor
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)

public class Author extends IdentityEntity {

    private String firstName;
    private String lastName;

    @Builder
    public Author(final String firstName, final String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }
}
