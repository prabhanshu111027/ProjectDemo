package com.example.demo.exception;

public class OrderAlreadyExistsException extends RuntimeException {
	private static final long serialVersionUID = 9157158902571316984L;
	private String message;

	public OrderAlreadyExistsException() {
	}

	public OrderAlreadyExistsException(String message) {
		super();
		this.message = message;
	}

}