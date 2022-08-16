package com.moulik.bookkeeper.exception;

public class BookKeeperException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private final String message;
	
	public BookKeeperException(String message) {
		this.message = message;
	}
	
}
