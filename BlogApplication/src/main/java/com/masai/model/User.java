package com.masai.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class User {
	
	@Id
	private Integer id;
	
	@NotNull
	private String userName;
	
	@NotNull
	private String password;
	
	@NotNull
	private String email;
}
