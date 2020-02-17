package com.fredrikpedersen.springmvcrest.exceptions;

/**
 * @author Fredrik Pedersen
 * @version 1.0
 * @since 17/02/2020 at 19:25
 */

public class ResourceNotFoundException extends RuntimeException {

    public ResourceNotFoundException() {

    }

    public ResourceNotFoundException(final String message) {
        super(message);
    }

    public ResourceNotFoundException(final String message, final Throwable cause) {
        super(message, cause);
    }

    public ResourceNotFoundException(final Throwable cause) {
        super(cause);
    }

    public ResourceNotFoundException(final String message, final Throwable cause, final boolean enableSuppression, final boolean writeableStackTrace) {
        super(message, cause, enableSuppression, writeableStackTrace);
    }
}
