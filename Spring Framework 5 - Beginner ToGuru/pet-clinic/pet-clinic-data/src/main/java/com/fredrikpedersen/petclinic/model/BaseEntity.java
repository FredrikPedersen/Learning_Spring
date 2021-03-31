package com.fredrikpedersen.petclinic.model;

import lombok.*;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import java.io.Serializable;

/**
 * @author Fredrik Pedersen
 * @version 1.1
 * @since 31/03/2021 at 11:43
 */

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@MappedSuperclass //Indicates that this is not going to be a database entity, and that other classes will inherit from it.
public abstract class BaseEntity implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    public boolean isNew() {
        return this.id == null;
    }
}
