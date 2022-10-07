package com.masai.DTO;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.masai.model.Comment;
import com.masai.model.Post;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CommentDTO {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer CommentId;
	
	@NotNull
	private String name;
	
	@NotNull
	private String email;
	
	private String body;
	
	
	@JsonIgnore
	@ManyToOne
	private Post post;
}
