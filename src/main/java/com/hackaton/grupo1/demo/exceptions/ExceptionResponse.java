package com.hackaton.grupo1.demo.exceptions;

import java.util.Date;

public record ExceptionResponse(Date timestamp, String message, String details) {
}
