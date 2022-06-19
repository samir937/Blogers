package com.example.blog.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.blog.entity.User;
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
	public ResponseEntity<Object> addNewUser(@RequestBody UserDto userDto)
	{
		UserDto newUser=userService.createUser(userDto);
		if(newUser==null)
		{
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
		}
		return ResponseEntity.status(HttpStatus.CREATED).body(userDto);
	}
	
	
	@PutMapping("/updateUser/{id}")
	public ResponseEntity<Object> updateUser(@RequestBody UserDto user, @PathVariable int id )
	{
		UserDto usedto=userService.updateUser(id, user);
		if(user==null) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		}
		
		return ResponseEntity.ok().body(usedto);
	}

}
