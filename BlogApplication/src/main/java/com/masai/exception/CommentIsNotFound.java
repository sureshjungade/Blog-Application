package com.masai.exception;

public class CommentIsNotFound extends RuntimeException{

	public CommentIsNotFound() {
		
	}
	
	public CommentIsNotFound(String msg) {
		super(msg);
	}
}
