package com.fredrik.pedersen.restclientexamples.api.domain;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

/**
 * @author Fredrik Pedersen
 * @version 1.0
 * @since 13/02/2020 at 21:59
 */

@Getter
@Setter
public class Job implements Serializable {

    private String title;
    private String company;
    private Map<String, Object> additionalProperties = new HashMap<>();
    private final static long serialVersionUID = -4985150429002262656L;
}
