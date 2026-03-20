package com.hackaton.grupo1.demo.exceptions;

import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.http.HttpStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class BadRequestException extends RuntimeException {
    public BadRequestException() {
        super("Unsupported file format");
    }

    public BadRequestException(String message) {
        super(message);
    }
}