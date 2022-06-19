package com.example.blog.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.blog.exception.*;
import com.example.blog.dao.UserRepo;
import com.example.blog.entity.User;
import com.example.blog.payload.UserDto;

@Service
public class UserServiceImpl implements UserService {
	
	@Autowired
	private UserRepo userRepo;

	@Override
	public UserDto createUser(UserDto user) {
		// TODO Auto-generated method stub
		User users=convertToEntity(user);
		userRepo.save(users);
		return user;
	}

	@Override
	public UserDto updateUser(int id, UserDto userdto) {
		// TODO Auto-generated method stub
		User users=userRepo.findById(id)
				.orElseThrow(()->new ResourceNotFoundException("Users", " id ", id));
		
		users.setName(userdto.getName());
		users.setEmail(userdto.getEmail());
		users.setPassword(userdto.getPassword());
		users.setAbout(userdto.getAbout());
	
		userRepo.save(users);
		
		return userdto;
	}

	@Override
	public void deleteUser(int id) {
		// TODO Auto-generated method stub
		
		User user=userRepo.findById(id).orElseThrow(()->new ResourceNotFoundException("User","Id",id));
		userRepo.delete(user);
	}

	@Override
	public List<UserDto> getAllUser() {
		// TODO Auto-generated method stub
		List<User> users=userRepo.findAll();
		List<UserDto> userList=users.stream().map(user->convertToDto(user)).collect(Collectors.toList());
		return userList;
	}

	@Override
	public UserDto getUserById(int id) {
		// TODO Auto-generated method stub
		UserDto userdto=convertToDto(userRepo.findById(id).get());
		return userdto;
	}
	
	public User convertToEntity(UserDto userdto)
	{
		User newuser=new User();
		//BeanUtils.copyProperties(userDto,newuser, getClass()); // to copy dto to entity (one bean to another)
		newuser.setId(userdto.getId());
		newuser.setName(userdto.getName());
		newuser.setEmail(userdto.getEmail());
		newuser.setPassword(userdto.getPassword());
		newuser.setAbout(userdto.getAbout());
		
		return newuser;
	}
	
	public UserDto convertToDto(User user)
	{
		UserDto newuserDto=new UserDto();
		//BeanUtils.copyProperties(newuserDto,user,getClass()); // to copy entity to dto (one bean to another)
		newuserDto.setId(user.getId());
		newuserDto.setName(user.getName());
		newuserDto.setEmail(user.getEmail());
		newuserDto.setPassword(user.getPassword());
		newuserDto.setAbout(user.getAbout());
		
		return newuserDto;
	}

}
