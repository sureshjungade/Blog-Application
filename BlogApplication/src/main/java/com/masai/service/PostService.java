package com.masai.service;

import java.util.List;

import org.springframework.data.domain.Page;

import com.masai.exception.DataIsEmpty;
import com.masai.exception.PostIsNotFound;
import com.masai.model.Post;

public interface PostService {

	public List<Post> getAllPostData() throws DataIsEmpty;
	
	public Post getPostDataById(Integer id) throws PostIsNotFound;
	
	public String createPost(Post post);
	
	public Post updatePostDataById(Integer id) throws PostIsNotFound;
	
	public String deletePostDataById(Integer id) throws PostIsNotFound;
	
	public Page<Post> paginationAndSorting(Integer pageNo,Integer pageSize, String sortingField,
			String sortingDirection);
}
