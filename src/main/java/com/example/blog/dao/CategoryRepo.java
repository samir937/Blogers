package com.example.blog.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.blog.entity.Category;

@Repository
public interface CategoryRepo extends JpaRepository<Category, Integer> {

} 
