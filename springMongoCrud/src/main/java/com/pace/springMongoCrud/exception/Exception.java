package com.pace.springMongoCrud.exception;

import com.pace.springMongoCrud.responses.ApiErrorResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@RestControllerAdvice
public class Exception extends ResponseEntityExceptionHandler {
    @ExceptionHandler
    public ResponseEntity<Object> bookNotFoundExceptionHandler(BookNotFoundException ex){
        ApiErrorResponse response = new ApiErrorResponse();
        response.setMessage(ex.getMessage());
        response.setHttpStatus(HttpStatus.NOT_FOUND.value());
        response.setData("No corresponding data available");
        return new ResponseEntity<>(response,HttpStatus.NOT_FOUND);
    }
}
