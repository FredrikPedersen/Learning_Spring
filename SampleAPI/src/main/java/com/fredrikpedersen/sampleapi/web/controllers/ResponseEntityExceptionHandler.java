package com.fredrikpedersen.sampleapi.web.controllers;

import com.fredrikpedersen.sampleapi.web.util.exceptions.ResourceNotFoundException;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

/**
 * @author Fredrik Pedersen
 * @version 1.0
 * @since 18.02.2020 at 10:42
 */

@ControllerAdvice
public class ResponseEntityExceptionHandler {

    @ExceptionHandler({ResourceNotFoundException.class})
    public ResponseEntity<Object> handleNotFoundException(final Exception exception, final WebRequest webRequest) {
        return new ResponseEntity<>("Resource Not Found", new HttpHeaders(), HttpStatus.NOT_FOUND);
    }
}
