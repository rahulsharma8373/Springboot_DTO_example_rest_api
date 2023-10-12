package com.rahul.Springboot.dto.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rahul.Springboot.dto.entity.User;
import com.rahul.Springboot.dto.entity.UserDto;
import com.rahul.Springboot.dto.mapper.UserMapper;
import com.rahul.Springboot.dto.repository.UserRepository;

@Service
public class UserServiceImpl implements UserService {
	@Autowired
	private UserRepository userRepository;

	@Override
	public UserDto createUser(UserDto userDto) {
// convert UserDto into User JPA Entity
		User user = UserMapper.mapToUser(userDto);
		User savedUser = userRepository.save(user);

//		User user1 = new User(userDto.getId(), userDto.getFirstName(), userDto.getLastName(), userDto.getEmail());
//		User savedUser = userRepository.save(user1);
//		// convert User JPA entity to UserDto
		UserDto savedUserDto = UserMapper.mapToUserDto(savedUser);
		return savedUserDto;
//		UserDto savedUserDto = new UserDto(savedUser.getId(), savedUser.getFirstName(), savedUser.getLastName(),
//				savedUser.getEmail());
//		return savedUserDto;

	}

	@Override
	public UserDto getUserById(Long userId) {

		Optional<User> optionalUser = userRepository.findById(userId);
		/// return optionalUser.get();
		User user = optionalUser.get();
		return UserMapper.mapToUserDto(user);

	}

	@Override
	public List<UserDto> getAllUsers() {

		List<User> users = userRepository.findAll();
		return users.stream().map(UserMapper::mapToUserDto).collect(Collectors.toList());
	}

	@Override
	public UserDto updateUser(UserDto user) {
		User existingUser = userRepository.findById(user.getId()).get();
		existingUser.setFirstName(user.getFirstName());
		existingUser.setLastName(user.getLastName());
		existingUser.setEmail(user.getEmail());
		User updatedUser = userRepository.save(existingUser);
		
		return UserMapper.mapToUserDto(updatedUser);
	}

	@Override
	public void deleteUser(Long userId) {
		userRepository.deleteById(userId);

	}

}
