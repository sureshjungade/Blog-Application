package com.masai.Dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.masai.model.User;

public interface UserRepo extends JpaRepository<User, Integer>{

}
