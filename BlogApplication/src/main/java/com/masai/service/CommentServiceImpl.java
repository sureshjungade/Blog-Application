package com.masai.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.masai.Dao.CommentRepo;
import com.masai.Dao.PostRepo;
import com.masai.exception.PostIsNotFound;
import com.masai.model.Comment;
import com.masai.model.Post;

@Service
public class CommentServiceImpl implements CommentService{

	@Autowired
	private CommentRepo cDao;
	
	@Autowired
	private PostRepo pDao;

	@Override
	public List<Comment> getAllComments(Integer postId) {

		Optional<Post> post = pDao.findById(postId);
		
		if(post.isEmpty()) {
			throw new PostIsNotFound("Post is not found");
		}else {
			
			
			
			return post.get().getComment();
		}
	}

	@Override
	public String createComment(Comment comment,Integer postId) {

		Optional<Post> post = pDao.findById(postId);
		
		if(post.isEmpty()) {
			throw new PostIsNotFound("Post is not found");
		}else {
			
			post.get().getComment().add(comment);
			comment.setPost(post.get());
			
			cDao.save(comment);
			
			return "Comment is Added to Post";
		}
	}

	@Override
	public Comment getCommentsById(Integer postId, Integer Id) {
		Optional<Post> post = pDao.findById(postId);
		
		if(post.isEmpty()) {
			throw new PostIsNotFound("Post is not found");
		}else {
			Comment ansComment = new Comment();
			
			for(Comment comment : post.get().getComment()) {
				if(comment.getCommentId()==Id) {
					ansComment = comment;
					break;
				}else {
					continue;
				}
				
			}
			return ansComment;
		}
	}

	@Override
	public String updateComment(Integer postId, Integer Id) {
		Optional<Post> post = pDao.findById(postId);
		if(post.isEmpty()) {
			throw new PostIsNotFound("Post is not found");
		}else {
			
			
			for(Comment comment : post.get().getComment()) {
				if(comment.getCommentId()==Id) {
					comment.setName("Gaurav");
					
					cDao.save(comment);
					break;
				}else {
					continue;
				}
				
			}
			return "Comment is Updated";
		}
		
		
	}

	@Override
	public String deleteComment(Integer postId, Integer Id) {
		Optional<Post> post = pDao.findById(postId);
		if(post.isEmpty()) {
			throw new PostIsNotFound("Post is not found");
		}else {
			
			Optional<Comment> comment = cDao.findById(Id);
			if(comment.isEmpty()) {
				throw new PostIsNotFound("Comment is not found");
			}else {
				cDao.deleteById(Id);
			}
			return "Comment is Deleted";
		}
	}
}
