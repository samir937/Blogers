package com.example.blog.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.blog.entity.Category;
import com.example.blog.entity.Post;
import com.example.blog.entity.User;

@Repository
public interface PostRepo extends JpaRepository<Post, Integer> {
	
	public List<Post> findByUser(User user);
	public List<Post> findByCategory(Category category);
	

}
