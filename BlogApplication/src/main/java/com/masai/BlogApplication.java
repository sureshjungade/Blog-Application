package com.masai;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class BlogApplication {

	@Autowired
	public ModelMapper modelmapper() {
		return new ModelMapper();
	}
	public static void main(String[] args) {
		SpringApplication.run(BlogApplication.class, args);
	}

}
