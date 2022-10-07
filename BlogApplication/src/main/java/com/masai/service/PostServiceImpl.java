package com.masai.service;

import java.awt.print.Pageable;
import java.util.List;
import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.masai.DTO.PostDTO;
import com.masai.Dao.PostRepo;
import com.masai.exception.DataIsEmpty;
import com.masai.exception.PostIsNotFound;
import com.masai.model.Post;

@Service
public class PostServiceImpl implements PostService{

	@Autowired
	private PostRepo pDao;
	
	@Autowired
	private ModelMapper modelMapper;

	@Override
	public List<Post> getAllPostData() throws DataIsEmpty{
		
		if(pDao.findAll()==null){
			throw new DataIsEmpty("Data is Empty");
		}else {
			this.modelMapper.map(Post.class, PostDTO.class);
			return pDao.findAll();
		}
	}

	@Override
	public Post getPostDataById(Integer id) throws PostIsNotFound {
		Optional<Post> post =  pDao.findById(id);
		if(post.isEmpty()){
			throw new PostIsNotFound("Post Is Not Found");
		}else {
			System.out.println(post.get());
			return post.get();
		}
	}

	@Override
	public String createPost(Post post) {

		pDao.save(post);
		
		return "Post is created";
	}

	@Override
	public Post updatePostDataById(Integer id) throws PostIsNotFound{

		Optional<Post> post =  pDao.findById(id);

		if(post.isEmpty()){
			throw new PostIsNotFound("Post Is Not Found");
		}else {
			
			post.get().setTitle("Best Practices for Java Backend Developer");
			pDao.save(post.get());
			
			return post.get();
		}
	}

	@Override
	public String deletePostDataById(Integer id) throws PostIsNotFound{
		Optional<Post> post =  pDao.findById(id);

		if(post.isEmpty()){
			throw new PostIsNotFound("Post Is Not Found");
		}else {
			pDao.delete(post.get());
			
			return "Post is Deleted with id :" + id;
		}
	}

	@Override
	public Page<Post> paginationAndSorting(Integer pageNo, Integer pageSize, String sortingField,
			String sortingDirection) {

		Sort sort = sortingDirection.equalsIgnoreCase(Sort.Direction.ASC.name()) ? Sort.by(sortingField).ascending():Sort.by(sortingField).descending();
			
		
		
		org.springframework.data.domain.Pageable pageable = PageRequest.of(pageNo - 1,pageSize,sort);
		
		return pDao.findAll(pageable);
	}
}
