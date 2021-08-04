package com.fredrikpedersen.brewery.domain.security;

import lombok.*;

import javax.persistence.*;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * @author Fredrik Pedersen
 * @version 1.0
 * @since 27/06/2021 at 15:31
 */

@Getter
@Setter
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    private String username;
    private String password;

    @Singular //Allows us to pass in a single Authority instead of a full set when using the builder.
    @ManyToMany(cascade = {CascadeType.MERGE, CascadeType.PERSIST}, fetch = FetchType.EAGER)
    @JoinTable(name = "user_role",
            joinColumns = {@JoinColumn(name = "USER", referencedColumnName = "ID")},
            inverseJoinColumns = {@JoinColumn(name = "ROLE_ID", referencedColumnName = "ID")})
    private Set<Role> roles;

    @Transient //Value is not persisted
    private Set<Authority> authorities;

    @Builder.Default //Builder.Default makes sure the builder defaults to the set value if nothing is provided when calling the builder
    private Boolean accountNonExpired = true;

    @Builder.Default
    private Boolean accountNonLocked = true;

    @Builder.Default
    private Boolean credentialsNonExpired = true;

    @Builder.Default
    private Boolean enabled = true;

    public Set<Authority> getAuthorities() {
        return this.roles.stream()
                .map(Role::getAuthorities)
                .flatMap(Set::stream)
                .collect(Collectors.toSet());
    }

}
