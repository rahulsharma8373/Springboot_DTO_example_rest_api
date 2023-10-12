package com.rahul.Springboot.dto.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.rahul.Springboot.dto.entity.User;


public interface UserRepository  extends JpaRepository<User, Long>{

	
}
