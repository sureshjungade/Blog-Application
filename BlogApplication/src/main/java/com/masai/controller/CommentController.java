package com.masai.controller;

import java.util.List;

import javax.validation.Valid;

import org.modelmapper.ModelMapper;
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

import com.masai.DTO.CommentDTO;
import com.masai.DTO.PostDTO;
import com.masai.model.Comment;
import com.masai.model.Post;
import com.masai.service.CommentService;

@RestController
@RequestMapping("/api/posts")
public class CommentController {

	@Autowired
	private CommentService cService;
	
//	@Autowired
//	private ModelMapper modelMapper;
	
	@GetMapping("/{Id}/comments/")
	public ResponseEntity<List<Comment>> getAllComment( @PathVariable Integer Id){
		
		return new ResponseEntity<>(cService.getAllComments(Id),HttpStatus.CREATED);
	}
	
	@GetMapping("/{postId}/comments/{Id}")
	public ResponseEntity<Comment> getAllComment( @PathVariable("postId") Integer postId,@PathVariable("Id") Integer Id){
		
//		Comment comment = cService.getCommentsById(postId, Id);
//		CommentDTO commentDTO =  this.modelMapper.map(comment, CommentDTO.class);
		
		
		return new ResponseEntity<>(cService.getCommentsById(postId, Id),HttpStatus.CREATED);
	}
	
	
	@PostMapping("/{Id}/comments/")
	public ResponseEntity<String> createPost(@Valid @RequestBody Comment comment,@PathVariable Integer Id){
		
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
