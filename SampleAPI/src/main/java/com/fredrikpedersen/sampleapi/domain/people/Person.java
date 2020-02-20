package com.fredrikpedersen.sampleapi.domain.people;

import com.fredrikpedersen.sampleapi.domain.BaseEntity;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;

/**
 * @author Fredrik Pedersen
 * @version 1.0
 * @since 18.02.2020 at 09:57
 */

@Getter
@Setter
@NoArgsConstructor
@MappedSuperclass
public abstract class Person extends BaseEntity {

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    public Person(final Long id, final String firstName, final String lastName) {
        super(id);
        this.firstName = firstName;
        this.lastName = lastName;
    }
}
