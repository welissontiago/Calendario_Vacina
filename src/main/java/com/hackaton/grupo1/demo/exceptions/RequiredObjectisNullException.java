package com.hackaton.grupo1.demo.exceptions;

import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.http.HttpStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class RequiredObjectisNullException extends RuntimeException {
    public RequiredObjectisNullException() {
        super("It is not allowed to persist a null object");

    }

    public RequiredObjectisNullException(String message) {
        super(message);
    }
}