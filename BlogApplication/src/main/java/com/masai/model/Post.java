package com.masai.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Post {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer postId;
	
	@Size(min=2, message = "Title should have atleast 2 characters")
	private String title;
	
	@Size(min=10, message = "Title should have atleast 8 characters")
	private String description;
	
	private String content;
	
	
	@JsonIgnore
	@OneToMany(mappedBy = "post",cascade = CascadeType.ALL)
	private List<Comment> comment;
	
	
	
  
}
