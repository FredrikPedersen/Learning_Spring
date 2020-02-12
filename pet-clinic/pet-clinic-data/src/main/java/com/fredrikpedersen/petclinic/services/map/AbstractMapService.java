package com.fredrikpedersen.petclinic.services.map;

import com.fredrikpedersen.petclinic.model.BaseEntity;

import java.util.*;

/**
 * @author Fredrik Pedersen
 * @version 1.0
 * @since 16/01/2020 at 14:21
 */

public abstract class AbstractMapService<T extends BaseEntity, ID extends Long> {

    protected Map<Long, T> map = new HashMap<>();

    Set<T> findAll() {
        return new HashSet<>(map.values());
    }

    T findById(ID id) {
        return map.get(id);
    }

    T save(T object) {
        if (object != null) {
            if (object.getId() == null) {
                object.setId(getNextId());
            }

            map.put(object.getId(), object);
        } else {
            throw  new RuntimeException("Object cannot be null!");
        }

        return object;
    }

    void deleteById(ID id) {
        map.remove(id);
    }

    void delete(T object) {
        map.entrySet().removeIf(entry -> entry.getValue().equals(object));
    }

    private Long getNextId() {

        //Checks if there are any elements in the map. If true, Returns the highest key (id), else it returns a value of 1.
        return map.size() > 0 ? Collections.max(map.keySet()) + 1 : 1L;
    }
}
