package com.fredrikpedersen.sampleapi.web.util.exceptions;

/**
 * @author Fredrik Pedersen
 * @version 1.1
 * @since 18.02.2020 at 10:33
 */

public final class ResourceNotFoundException extends RuntimeException {

    public ResourceNotFoundException() { }

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
