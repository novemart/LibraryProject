package com.example.LibrarySpringBoot.controller;

import com.example.LibrarySpringBoot.exception.InvalidIdException;
import com.example.LibrarySpringBoot.exception.MemberNotFoundException;
import org.springdoc.api.ErrorMessage;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;



@ControllerAdvice
public class WebExceptionHandler {

    @ExceptionHandler({MemberNotFoundException.class})
    public final ResponseEntity<ErrorMessage> handleMemberNotFound(Exception ex, WebRequest request) {
        int status = HttpStatus.NOT_FOUND.value();
        return ResponseEntity.status(status).body(new ErrorMessage(ex.getMessage()));
    }

    @ExceptionHandler({InvalidIdException.class})
    public final ResponseEntity<ErrorMessage> handleInvalidId(Exception ex, WebRequest request) {
        int status = HttpStatus.REQUESTED_RANGE_NOT_SATISFIABLE.value();
        return ResponseEntity.status(status).body(new ErrorMessage(ex.getMessage()));
    }
}
