package com.example.blog.repo;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;

import org.aspectj.lang.annotation.Before;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.blog.dao.UserRepo;
import com.example.blog.entity.User;

@SpringBootTest
public class UserRepoTest {
	
	@Autowired
	private UserRepo userRepo;
	
	@Test
	void findById()
	{
	    List<User> us=userRepo.findAll();
	    int s=us.size();
	    assertEquals(4,s);   
	}
	
}
