package com.fredrikpedersen.springmvcrest.controllers.v1;

import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * @author Fredrik Pedersen
 * @version 1.0
 * @since 16/02/2020 at 18:56
 */

public abstract class AbstractRestControllerTest {

    public static String asJsonString(final Object object) {
        try {
            return new ObjectMapper().writeValueAsString(object);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
