package com.fredrik.pedersen.restclientexamples.api.domain;

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
public class Name implements Serializable {

    private String title;
    private String first;
    private String last;
    private Map<String, Object> additionalProperties = new HashMap<>();
    private final static long serialVersionUID = 420620315591775395L;
}
