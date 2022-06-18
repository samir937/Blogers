package com.example.blog.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.blog.entity.BlogEntity;

public interface BlogDao extends JpaRepository<BlogEntity, Integer> {

}
