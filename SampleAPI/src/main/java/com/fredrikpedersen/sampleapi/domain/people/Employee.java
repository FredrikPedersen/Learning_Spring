package com.fredrikpedersen.sampleapi.domain.people;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * @author Fredrik Pedersen
 * @version 1.0
 * @since 11.02.2020 at 11:45
 */

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "employees")
public class Employee extends Person {

    @Column(name = "department")
    private String department;

    public Employee (final Long id, final String firstName, final String lastName, final String department) {
        super(id, firstName, lastName);
        this.department = department;
    }
}
