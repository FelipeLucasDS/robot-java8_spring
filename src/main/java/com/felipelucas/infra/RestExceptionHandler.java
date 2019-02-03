package com.felipelucas.infra;

import com.felipelucas.commons.exceptions.CommandWrongException;
import com.felipelucas.commons.exceptions.OutOfBoundsException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class RestExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler({CommandWrongException.class})
    public ResponseEntity<String> CommandWrongException(CommandWrongException ex) {
        return new ResponseEntity(ErrorBody.builder()
                .message("Got a wrong command")
                .errorObject(ex.getCommandStep())
                .build(),
                HttpStatus.PRECONDITION_FAILED);
    }

    @ExceptionHandler({OutOfBoundsException.class})
    public ResponseEntity<String> OutOfBoundsException(OutOfBoundsException ex) {
        return new ResponseEntity(ErrorBody.builder()
                .message("Went out of bounds")
                .errorObject(ex.getCommandStep())
                .build(),
                HttpStatus.EXPECTATION_FAILED);
    }

    @ExceptionHandler({Exception.class})
    public ResponseEntity<String> handleException(Exception ex) {
        ex.printStackTrace();
        return new ResponseEntity<>(ex.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
    }

}