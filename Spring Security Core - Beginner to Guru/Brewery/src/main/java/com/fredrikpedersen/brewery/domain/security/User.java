package com.fredrikpedersen.brewery.domain.security;

import javax.persistence.*;
import java.util.Set;

/**
 * @author Fredrik Pedersen
 * @version 1.0
 * @since 27/06/2021 at 15:31
 */

@Entity
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    private String username;
    private String password;

    @ManyToMany(cascade = CascadeType.MERGE)
    @JoinTable(name = "user_authority",
            joinColumns = {@JoinColumn(name = "USER", referencedColumnName = "ID")},
            inverseJoinColumns = {@JoinColumn(name = "AUTHORITY_ID", referencedColumnName = "ID")})
    private Set<Authority> authorities;
    private Boolean accountNonExpired = true;
    private Boolean accountNonLocked = true;
    private Boolean credentialsNonExpired = true;
    private Boolean enabled = true;

}
