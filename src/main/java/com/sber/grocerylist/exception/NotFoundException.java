package com.sber.grocerylist.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

/**
 * Signals that a resource requested by a client was not found on the server.
 */
public class NotFoundException extends ResponseStatusException {
    /**
     * Constructor with a detail message.
     *
     * @param message the detail message
     */
    public NotFoundException(String message) {
        super(HttpStatus.NOT_FOUND, message);
    }
}
