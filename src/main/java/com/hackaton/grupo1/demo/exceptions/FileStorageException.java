package com.hackaton.grupo1.demo.exceptions;

import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.http.HttpStatus;

@ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
public class FileStorageException extends RuntimeException {

    public FileStorageException(String message) {

        super(message);
    }

    public FileStorageException(String message, Throwable cause) {
        super(cause);
    }
}