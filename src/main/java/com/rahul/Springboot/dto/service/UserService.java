package com.rahul.Springboot.dto.service;

import java.util.List;

import com.rahul.Springboot.dto.entity.User;
import com.rahul.Springboot.dto.entity.UserDto;

public interface UserService {

	public UserDto createUser(UserDto user);

	UserDto getUserById(Long userId);

	List<UserDto> getAllUsers();

	UserDto updateUser(UserDto user);

	void deleteUser(Long userId);
}
