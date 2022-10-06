package com.masai.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.masai.model.Comment;
import com.masai.service.CommentService;

@RestController
@RequestMapping("/api/posts")
public class CommentController {

	@Autowired
	private CommentService cService;
	
	
	@GetMapping("/{Id}/comments/")
	public ResponseEntity<List<Comment>> getAllComment(@PathVariable Integer Id){
		
		return new ResponseEntity<>(cService.getAllComments(Id),HttpStatus.CREATED);
	}
	
	@GetMapping("/{postId}/comments/{Id}")
	public ResponseEntity<Comment> getAllComment(@PathVariable("postId") Integer postId,@PathVariable("Id") Integer Id){
		
		return new ResponseEntity<>(cService.getCommentsById(postId, Id),HttpStatus.CREATED);
	}
	
	
	@PostMapping("/{Id}/comments/")
	public ResponseEntity<String> createPost(@RequestBody Comment comment,@PathVariable Integer Id){
		
		return new ResponseEntity<>(cService.createComment(comment,Id),HttpStatus.CREATED);
	}
	
	@PutMapping("/{postId}/comments/{Id}")
	public ResponseEntity<String> updatePost(@PathVariable("postId") Integer postId,@PathVariable("Id") Integer Id){
		
		return new ResponseEntity<>(cService.updateComment(postId, Id),HttpStatus.CREATED);
	}
	
	@DeleteMapping("/{postId}/comments/{Id}")
	public ResponseEntity<String> deletePost(@PathVariable("postId") Integer postId,@PathVariable("Id") Integer Id){
		
		return new ResponseEntity<>(cService.deleteComment(postId, Id),HttpStatus.CREATED);
	}
}
