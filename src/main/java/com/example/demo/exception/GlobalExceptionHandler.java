package com.example.demo.exception;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {
	private static final Logger LOGGER = LoggerFactory.getLogger(
            GlobalExceptionHandler.class);

@ExceptionHandler()
public String handleConnectionError(Exception ex) {

LOGGER.error(ex.getMessage(), ex);

return "connect_error";
}

}