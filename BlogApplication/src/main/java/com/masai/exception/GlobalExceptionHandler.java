package com.masai.exception;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.NoHandlerFoundException;

@ControllerAdvice
public class GlobalExceptionHandler {

	@ExceptionHandler(DataIsEmpty.class)
	ResponseEntity<ErrorDetails> DataEmptyFoundHandler(DataIsEmpty bnf, WebRequest wr){
		
		ErrorDetails err = new ErrorDetails();
		
		err.setDateTime(LocalDateTime.now());
		err.setMessage(bnf.getMessage());
		err.setDescription(wr.getDescription(false));
		return new ResponseEntity<ErrorDetails>(err,HttpStatus.BAD_REQUEST);
	}
	
	@ExceptionHandler(PostIsNotFound.class)
	ResponseEntity<ErrorDetails> postNotFoundFoundHandler(PostIsNotFound bnf, WebRequest wr){
		
		ErrorDetails err = new ErrorDetails();
		
		err.setDateTime(LocalDateTime.now());
		err.setMessage(bnf.getMessage());
		err.setDescription(wr.getDescription(false));
		return new ResponseEntity<ErrorDetails>(err,HttpStatus.BAD_REQUEST);
	}
	
	@ExceptionHandler(CommentIsNotFound.class)
	ResponseEntity<ErrorDetails>commentNotFoundFoundHandler(CommentIsNotFound bnf, WebRequest wr){
		
		ErrorDetails err = new ErrorDetails();
		
		err.setDateTime(LocalDateTime.now());
		err.setMessage(bnf.getMessage());
		err.setDescription(wr.getDescription(false));
		return new ResponseEntity<ErrorDetails>(err,HttpStatus.BAD_REQUEST);
	}
	
	@ExceptionHandler(NoHandlerFoundException.class)
	ResponseEntity<ErrorDetails> noHandlerFoundException(NoHandlerFoundException bnf, WebRequest wr){
		
		ErrorDetails err = new ErrorDetails();
		
		err.setDateTime(LocalDateTime.now());
		err.setMessage(bnf.getMessage());
		err.setDescription(wr.getDescription(false));
		return new ResponseEntity<ErrorDetails>(err,HttpStatus.BAD_REQUEST);
	}
	
	@ExceptionHandler(Exception.class)
	ResponseEntity<ErrorDetails> exceptionFoundFoundHandler(Exception bnf, WebRequest wr){
		
		ErrorDetails err = new ErrorDetails();
		
		err.setDateTime(LocalDateTime.now());
		err.setMessage(bnf.getMessage());
		err.setDescription(wr.getDescription(false));
		return new ResponseEntity<ErrorDetails>(err,HttpStatus.BAD_REQUEST);
	}
}
