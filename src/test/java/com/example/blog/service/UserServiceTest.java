package com.example.blog.service;

import static org.mockito.Mockito.verify;

import org.aspectj.lang.annotation.Before;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;

import com.example.blog.dao.UserRepo;

//@ExtendWith(MockitoExtension.class)
public class UserServiceTest {

	@Mock
	private UserRepo userRepo;
	
	private UserService userService;
	
	AutoCloseable autoCloseable;
	
	@BeforeEach
	void setUp()
	{
		autoCloseable=MockitoAnnotations.openMocks(this);
		userService=new UserServiceImpl(this.userRepo); // fake repo object is passed
	}
		
	@Test
	void getAllUser()
	{
		userService.getAllUser();
		verify(userRepo).findAll();
	}

}
