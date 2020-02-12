package com.fredrikpedersen.petclinic.services;

import java.util.Set;

/**
 * @author Fredrik Pedersen
 * @version 1.0
 * @since 16/01/2020 at 14:14
 */

public interface CrudService<T, ID> {

    Set<T> findAll();
    T findById(ID id);
    T save(T object);
    void delete(T object);
    void deleteById(ID id);

}
