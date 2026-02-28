package com.libraryManagementSystem.exception;

public class BookNotFoundException extends RuntimeException{

	public BookNotFoundException(String msg)
	{
		super(msg);
	}
}
