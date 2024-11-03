package com.anki.controller;



import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.anki.exception.CustomException;
import com.anki.exception.GenaricException;
import com.anki.models.ErrorResponse;
@ControllerAdvice

public class GlobalExceptionController {
    private static final Logger logger = LoggerFactory.getLogger(GlobalExceptionController.class);

	   @ExceptionHandler(CustomException.class)
	    public ResponseEntity<ErrorResponse> handleResourceNotFoundException(CustomException ex) {
	        logger.error("Custom exception occurred: {}", ex.getMessage(), ex);
	        ErrorResponse errorResponse = new ErrorResponse(HttpStatus.INTERNAL_SERVER_ERROR.value(), ex.getMessage());
	        return new ResponseEntity<>(errorResponse, HttpStatus.NOT_FOUND);
	    }
	   
	   @ExceptionHandler(GenaricException.class)
	    public ResponseEntity<ErrorResponse> handleResourceNotFoundException(GenaricException ex) {
	        logger.error("Custom exception occurred: {}", ex.getMessage(), ex);
	        ErrorResponse errorResponse = new ErrorResponse(HttpStatus.INTERNAL_SERVER_ERROR.value(), ex.getMessage());
	        return new ResponseEntity<>(errorResponse, HttpStatus.NOT_FOUND);
	    }
	   
	   @ExceptionHandler(MethodArgumentNotValidException.class)
	    public ResponseEntity<Map<String, String>> handleValidationExceptions(
	            MethodArgumentNotValidException ex) {
	        Map<String, String> errors = new HashMap<>();
	        ex.getBindingResult().getAllErrors().forEach((error) -> {
	            String fieldName = ((FieldError) error).getField();
	            String errorMessage = error.getDefaultMessage();
	            errors.put(fieldName, errorMessage);
	        });
	        return ResponseEntity.badRequest().body(errors);
	    }
}

