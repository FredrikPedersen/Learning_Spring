package com.fredrik.pedersen.api.domain;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

/**
 * @author Fredrik Pedersen
 * @version 1.0
 * @since 13/02/2020 at 22:01
 */

@Getter
@Setter
public class User implements Serializable {

    private String gender;
    private Name name;
    private Location location;
    private String email;
    private Login login;
    private String phone;
    private Job job;
    private Billing billing;
    private String language;
    private String currency;
    private Map<String, Object> additionalProperties = new HashMap<>();
}
