package com.pradeep.orderservice.exception;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.pradeep.orderservice.dto.ApiError;

import jakarta.servlet.http.HttpServletRequest;

@RestControllerAdvice
public class GlobalExceptionHandler {
	
	@ExceptionHandler(OrderNotFoundException.class)
    public ResponseEntity<ApiError> handleOrderNotFound(
            OrderNotFoundException ex, HttpServletRequest request) {

		ApiError error = new ApiError(
                LocalDateTime.now(),
                HttpStatus.NOT_FOUND.value(),
                ex.getMessage(),
                request.getRequestURI());

        return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body(error);
    }

}
