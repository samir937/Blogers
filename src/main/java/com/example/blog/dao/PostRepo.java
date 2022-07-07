package com.example.blog.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.blog.entity.Post;


public interface PostRepo extends JpaRepository<Post, Integer> {

}
