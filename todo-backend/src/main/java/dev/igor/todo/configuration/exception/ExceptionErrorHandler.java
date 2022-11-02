package dev.igor.todo.configuration.exception;

import dev.igor.todo.exceptions.ObjectNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import javax.servlet.ServletRequest;

@ControllerAdvice
public class ExceptionErrorHandler {

    @ExceptionHandler(ObjectNotFoundException.class)
    public ResponseEntity<DefaultError> objectNotFoundException(ObjectNotFoundException ex, ServletRequest request) {
        var error = new DefaultError(System.currentTimeMillis(), HttpStatus.NOT_FOUND.value(), ex.getMessage());
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(error);
    }
}
