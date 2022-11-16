package com.book.exception;

import java.util.NoSuchElementException;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class BookGlobalException {
	
	@ExceptionHandler(NoSuchElementException.class)
	public ResponseEntity<String> handleNoSuchElementException
	(NoSuchElementException noSuchElementException)
	{
		return new ResponseEntity<String>("No such element "
    + "present in DB, please change your request",HttpStatus.NOT_FOUND);
	}
	@ExceptionHandler(HttpRequestMethodNotSupportedException.class)
	public ResponseEntity<String> handleMethodNotSupported
	(HttpRequestMethodNotSupportedException methodNotSupported)
	{
		return new ResponseEntity<String>("No such method "
    + "present , please change Http Method type",HttpStatus.NOT_FOUND);
	}

}
