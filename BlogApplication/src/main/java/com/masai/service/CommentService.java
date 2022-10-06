package com.masai.service;

import java.util.List;

import com.masai.model.Comment;

public interface CommentService {

	public List<Comment> getAllComments(Integer postId);
	
	public Comment getCommentsById(Integer postId,Integer Id);
	
	public String createComment(Comment comment,Integer postId);
	
	public String updateComment(Integer postId,Integer Id);
	
	public String deleteComment(Integer postId,Integer Id);
}
