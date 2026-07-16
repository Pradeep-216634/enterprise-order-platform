package com.pradeep.orderservice.exception;

public class DuplicateResourceException extends RuntimeException{
	public DuplicateResourceException(String message) {
        super(message);
    }
}
