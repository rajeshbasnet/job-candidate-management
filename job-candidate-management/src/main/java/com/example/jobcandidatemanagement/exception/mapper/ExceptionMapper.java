package com.example.jobcandidatemanagement.exception.mapper;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ExceptionMapper {

    @ExceptionHandler({Exception.class})
    public ResponseEntity returnResponseFromException(Exception exception) {
        return new ResponseEntity(exception.getMessage(), HttpStatus.BAD_REQUEST);
    }


    //TODO: Create handler for each exception with proper response
}
