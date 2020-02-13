package com.fredrik.pedersen.api.domain;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

/**
 * @author Fredrik Pedersen
 * @version 1.0
 * @since 13/02/2020 at 22:00
 */

@Getter
@Setter
public class Location implements Serializable {

    private String street;
    private String city;
    private String state;
    private String postcode;
    private Map<String, Object> additionalProperties = new HashMap<>();
    private final static long serialVersionUID = -3532048267747973846L;
}
