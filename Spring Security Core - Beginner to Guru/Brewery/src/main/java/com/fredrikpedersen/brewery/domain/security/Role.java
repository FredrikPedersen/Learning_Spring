package com.fredrikpedersen.brewery.domain.security;

import lombok.*;

import javax.persistence.*;
import java.util.Set;

/**
 * @author Fredrik Pedersen
 * @version 1.0
 * @since 04/08/2021 at 16:58
 */

@Getter
@Setter
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Role {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    private String name;

    @ManyToMany(mappedBy = "roles")
    private Set<User> users;

    @Singular //Allows us to pass in a single Authority instead of a full set when using the builder.
    @ManyToMany(cascade = {CascadeType.MERGE, CascadeType.PERSIST}, fetch = FetchType.EAGER)
    @JoinTable(name = "role_authority",
            joinColumns = {@JoinColumn(name = "ROLE_ID", referencedColumnName = "ID")},
            inverseJoinColumns = {@JoinColumn(name = "AUTHORITY_ID", referencedColumnName = "ID")})
    private Set<Authority> authorities;

}
