package com.fredrik.pedersen.api.domain;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

/**
 * @author Fredrik Pedersen
 * @version 1.0
 * @since 13/02/2020 at 21:58
 */

@Getter
@Setter
public class ExpirationDate implements Serializable {

    private String date;
    private Integer timezoneType;
    private String timezone;
    private Map<String, Object> additionalProperties = new HashMap<>();
    private final static long serialVersionUID = 4661228813349752965L;
}
