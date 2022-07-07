package com.example.blog.controller;


import java.util.List;

import javax.validation.Valid;

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

import com.example.blog.entity.User;
import com.example.blog.payload.ApiResponse;
import com.example.blog.payload.UserDto;
import com.example.blog.service.UserService;

@RestController
@RequestMapping("/api/users/")
public class UserController {
	
	@Autowired
	private UserService userService;
	
	@GetMapping("/allUsers")
	public ResponseEntity<Object> getAllUsers()
	{
		List<UserDto> allUsers=userService.getAllUser();
		if(allUsers.size()<=0)
		{
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.status(HttpStatus.OK).body(allUsers);
	}
	
	@PostMapping("/addUsers")
	public ResponseEntity<UserDto> createNewUser(@Valid @RequestBody UserDto userDto)
	{
		UserDto newUser=userService.createUser(userDto);
		return ResponseEntity.status(HttpStatus.CREATED).body(userDto);
	}
	
	
	@PutMapping("/updateUser/{id}")
	public ResponseEntity<UserDto> updateUser(@Valid @RequestBody UserDto user, @PathVariable int id )
	{
		UserDto updatedUser=userService.updateUser(id, user);
		return new ResponseEntity<UserDto>(updatedUser,HttpStatus.OK);
		
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<ApiResponse> deleteUser(@PathVariable Integer id)
	{
		userService.deleteUser(id);
		return new ResponseEntity(new ApiResponse("User Deleted Successfully !!!",true),HttpStatus.OK);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<UserDto> getUserById(@PathVariable Integer id)
	{
		UserDto user=userService.getUserById(id); 
		return new ResponseEntity<UserDto>(user,HttpStatus.OK);
	}

}
