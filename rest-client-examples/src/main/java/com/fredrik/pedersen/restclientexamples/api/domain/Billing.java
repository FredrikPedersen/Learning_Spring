package com.fredrik.pedersen.restclientexamples.api.domain;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

/**
 * @author Fredrik Pedersen
 * @version 1.0
 * @since 13/02/2020 at 21:56
 */

@Getter
@Setter
public class Billing implements Serializable {

    private Card card;
    private Map<String, Object> additionalProperties = new HashMap<>();
    private final static long serialVersionUID = 6577338081290507077L;
}
