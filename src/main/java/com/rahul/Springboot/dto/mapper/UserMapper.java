package com.rahul.Springboot.dto.mapper;

import com.rahul.Springboot.dto.entity.User;
import com.rahul.Springboot.dto.entity.UserDto;

public class UserMapper {
// convert User JPA ENTIT into UserDto
	public static UserDto mapToUserDto(User user) {
		UserDto userDto=new UserDto(user.getId(),user.getFirstName(),user.getLastName(),user.getEmail());
		return userDto;
	}
	// convert UserDto into User JPA ENtity
	public static User mapToUser(UserDto userDto) {
		User user1=new User(userDto.getId(),userDto.getFirstName(),userDto.getLastName(),userDto.getEmail());
		return user1;
	}
}
