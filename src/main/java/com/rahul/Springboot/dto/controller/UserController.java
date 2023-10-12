package com.rahul.Springboot.dto.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rahul.Springboot.dto.entity.User;
import com.rahul.Springboot.dto.entity.UserDto;
import com.rahul.Springboot.dto.service.UserService;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@RestController
@RequestMapping("api/users")
public class UserController {
	@Autowired
	private UserService userService;

	// build create UserbRest Api
	@PostMapping
	public ResponseEntity<UserDto> createUser(@RequestBody UserDto user) {
		UserDto savedUser = userService.createUser(user);
		return new ResponseEntity<>(savedUser, HttpStatus.CREATED);

	}

	// get user by id rest api
	@GetMapping("{id}")
	public ResponseEntity<UserDto> getUserById(@PathVariable("id") Long userId) {
		UserDto user = userService.getUserById(userId);
		return new ResponseEntity<>(user, HttpStatus.OK);
	}

	@GetMapping("allUsers")
	public ResponseEntity<List<UserDto>> getAllUsers() {
		List<UserDto> users = userService.getAllUsers();
		return new ResponseEntity<>(users, HttpStatus.OK);
	}

	// update rest api
	@PutMapping("{id}")
	public ResponseEntity<UserDto> updateUsers(@PathVariable("id") Long userId,@RequestBody UserDto user) {
		user.setId(userId);
		UserDto UpdateUser = userService.updateUser(user);
		return new ResponseEntity<>(UpdateUser, HttpStatus.OK);
	}
	// delete user rest api
	@DeleteMapping("{id}")
	public ResponseEntity<String> deleteUser(@PathVariable("id") Long userId){
		userService.deleteUser(userId);
		return new ResponseEntity<>("user successfully deleted",HttpStatus.OK);
	}
	
	
	
}