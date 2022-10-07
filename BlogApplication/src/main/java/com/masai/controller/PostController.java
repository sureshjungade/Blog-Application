package com.masai.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.masai.model.Post;
import com.masai.service.PostService;

@RestController
@RequestMapping("/api/posts")
public class PostController {

	@Autowired
	private PostService pService;
	
	@GetMapping("/")
	public ResponseEntity<List<Post>> getAllPost(){
		
		return new ResponseEntity<>(pService.getAllPostData(),HttpStatus.OK);
	}
	
	@GetMapping("/{Id}")
	public ResponseEntity<Post> getPostById(@Valid @PathVariable Integer Id){
		
		return new ResponseEntity<>(pService.getPostDataById(Id),HttpStatus.OK);
	}
	
	@PostMapping("/")
	public ResponseEntity<String> createPost(@Valid @RequestBody Post post){
		
		return new ResponseEntity<>(pService.createPost(post),HttpStatus.CREATED);
	}
	
	@PutMapping("/{Id}")
	public ResponseEntity<Post> updatePost(@Valid @PathVariable Integer Id){
		
		return new ResponseEntity<>(pService.updatePostDataById(Id),HttpStatus.OK);
	}
	
	@DeleteMapping("/{Id}")
	public ResponseEntity<String> deletePostById(@Valid @PathVariable Integer Id){
		
		return new ResponseEntity<>(pService.deletePostDataById(Id),HttpStatus.OK);
	}
	
	//http://localhost:8088/api/posts/paginationAndSorting/1?pageSize=2&sortingField=title&sortingDirection=DESC
	@GetMapping("/paginationAndSorting")
	public ResponseEntity<Page<Post>> paginationAndSorting(@Valid @RequestParam(required = false, defaultValue = "1") Integer pageNo,@RequestParam(required = false, defaultValue = "10")Integer pageSize, @RequestParam(required = false, defaultValue = "title")String sortingField, @RequestParam(required = false, defaultValue = "ASC") String sortingDirection){
		
		return new ResponseEntity<>(pService.paginationAndSorting(pageNo, pageSize, sortingField, sortingDirection),HttpStatus.OK);
	}
}
