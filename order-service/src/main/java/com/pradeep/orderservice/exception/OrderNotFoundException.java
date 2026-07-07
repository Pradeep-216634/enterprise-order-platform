package com.pradeep.orderservice.exception;

public class OrderNotFoundException extends RuntimeException{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 2537990240367975169L;

	public OrderNotFoundException(String message) {
        super(message);
    }

}
