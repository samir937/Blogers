package com.example.blog.service;

import java.util.List;

import com.example.blog.payload.UserDto;

public interface UserService {
	
	 UserDto createUser(UserDto user);
	 UserDto updateUser(int id,UserDto user);
	 void deleteUser(int id);
	 List<UserDto> getAllUser();
	 UserDto getUserById(int id);
	 
	  	
	 
}
