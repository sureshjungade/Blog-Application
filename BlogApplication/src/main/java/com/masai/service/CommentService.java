package com.masai.service;

import java.util.List;

import com.masai.exception.CommentIsNotFound;
import com.masai.exception.PostIsNotFound;
import com.masai.model.Comment;

public interface CommentService {

	public List<Comment> getAllComments(Integer postId)throws PostIsNotFound;
	
	public Comment getCommentsById(Integer postId,Integer Id)throws PostIsNotFound;
	
	public String createComment(Comment comment,Integer postId)throws PostIsNotFound;
	
	public String updateComment(Integer postId,Integer Id)throws PostIsNotFound;
	
	public String deleteComment(Integer postId,Integer Id)throws CommentIsNotFound;
}
