package com.crio.learning_navigator.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.CONFLICT)
public class EnrollmentException extends RuntimeException {
    public EnrollmentException(String message) {
        super(message);
    }
}