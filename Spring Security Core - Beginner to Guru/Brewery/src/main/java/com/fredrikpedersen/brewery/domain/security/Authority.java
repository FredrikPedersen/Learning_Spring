package com.fredrikpedersen.brewery.domain.security;

import javax.persistence.*;
import java.util.Set;

/**
 * @author Fredrik Pedersen
 * @version 1.0
 * @since 27/06/2021 at 15:32
 */

@Entity
public class Authority {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    private String role;

    @ManyToMany(mappedBy = "authorities")
    private Set<User> users;

}
