package com.masai.exception;

public class PostIsNotFound extends RuntimeException{

	public PostIsNotFound() {
		
	}
	
	public PostIsNotFound(String msg) {
		super(msg);
	}
}
