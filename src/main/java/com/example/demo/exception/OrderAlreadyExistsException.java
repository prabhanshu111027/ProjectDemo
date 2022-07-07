package com.example.demo.exception;

public class OrderAlreadyExistsException extends RuntimeException {
	private String message;

	public OrderAlreadyExistsException() {
	}

	public OrderAlreadyExistsException(String message) {
		super();
		this.message = message;
	}

}