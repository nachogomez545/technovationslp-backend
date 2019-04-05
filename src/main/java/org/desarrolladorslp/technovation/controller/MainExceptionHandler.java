package org.desarrolladorslp.technovation.controller;

import java.util.NoSuchElementException;

import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@Order(Ordered.HIGHEST_PRECEDENCE)
@ControllerAdvice
public class MainExceptionHandler {

    @ExceptionHandler({IllegalArgumentException.class})
    public ResponseEntity<Error> handleBadInputException(Exception ex) {
        return new ResponseEntity<>(new Error()
                .exception(ex.getClass().getCanonicalName())
                .message(ex.getMessage()), HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler({NoSuchElementException.class})
    public ResponseEntity<Error> handleNoSuchElementException(Exception ex) {
        return new ResponseEntity<>(new Error()
                .exception(ex.getClass().getCanonicalName())
                .message(ex.getMessage()), HttpStatus.NOT_FOUND);
    }

    public static class Error {
        String message;
        String exception;

        Error message(String message) {
            this.message = message;
            return this;
        }

        Error exception(String exception) {
            this.exception = exception;
            return this;
        }
    }

}