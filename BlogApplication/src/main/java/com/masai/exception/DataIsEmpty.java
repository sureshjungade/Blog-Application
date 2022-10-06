package com.masai.exception;

public class DataIsEmpty extends RuntimeException{

	public DataIsEmpty() {
		
	}
	
	public DataIsEmpty(String msg) {
		super(msg);
	}
}
