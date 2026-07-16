package com.pradeep.orderservice.exception;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.pradeep.orderservice.dto.ApiError;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.validation.ConstraintViolationException;
import lombok.extern.slf4j.Slf4j;

@RestControllerAdvice
@Slf4j
public class GlobalExceptionHandler {
	
	@ExceptionHandler(OrderNotFoundException.class)
    public ResponseEntity<ApiError> handleOrderNotFound(
            OrderNotFoundException ex, HttpServletRequest request) {

		ApiError error = new ApiError(
                LocalDateTime.now(),
                HttpStatus.NOT_FOUND.value(),
                HttpStatus.NOT_FOUND.getReasonPhrase(),
                ex.getMessage(),
                request.getRequestURI(), null);

        return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body(error);
    }
	
	@ExceptionHandler(DuplicateResourceException.class)
	public ResponseEntity<ApiError> handleDuplicate(
	        DuplicateResourceException ex,
	        HttpServletRequest request) {

	    ApiError error = new ApiError(
	            LocalDateTime.now(),
	            HttpStatus.CONFLICT.value(),
	            HttpStatus.CONFLICT.getReasonPhrase(),
	            ex.getMessage(),
	            request.getRequestURI(),
	            null);

	    return ResponseEntity.status(HttpStatus.CONFLICT)
	            .body(error);
	}
	
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ResponseEntity<ApiError> handleValidation(
	        MethodArgumentNotValidException ex,
	        HttpServletRequest request) {

	    List<String> errors = ex.getBindingResult()
	            .getFieldErrors()
	            .stream()
	            .map(field ->
	                    field.getField() + " : " + field.getDefaultMessage())
	            .toList();

	    ApiError error = new ApiError(
	            LocalDateTime.now(),
	            HttpStatus.BAD_REQUEST.value(),
	            HttpStatus.BAD_REQUEST.getReasonPhrase(),
	            "Validation Failed",
	            request.getRequestURI(),
	            errors);

	    return ResponseEntity.badRequest().body(error);
	}
	
	@ExceptionHandler(ConstraintViolationException.class)
	public ResponseEntity<ApiError> handleConstraintViolation(
	        ConstraintViolationException ex,
	        HttpServletRequest request) {

	    List<String> errors = ex.getConstraintViolations()
	            .stream()
	            .map(v -> v.getPropertyPath() + " : " + v.getMessage())
	            .toList();

	    ApiError error = new ApiError(
	            LocalDateTime.now(),
	            HttpStatus.BAD_REQUEST.value(),
	            HttpStatus.BAD_REQUEST.getReasonPhrase(),
	            "Validation Failed",
	            request.getRequestURI(),
	            errors);

	    return ResponseEntity.badRequest().body(error);
	}
	
	@ExceptionHandler(Exception.class)
	public ResponseEntity<ApiError> handleException(
	        Exception ex,
	        HttpServletRequest request) {

	    log.error("Unhandled exception", ex);

	    ApiError error = new ApiError(
	            LocalDateTime.now(),
	            HttpStatus.INTERNAL_SERVER_ERROR.value(),
	            HttpStatus.INTERNAL_SERVER_ERROR.getReasonPhrase(),
	            ex.getMessage(),
	            request.getRequestURI(),
	            null);

	    return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
	            .body(error);
	}

}
