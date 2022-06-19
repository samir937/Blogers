package com.example.blog.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.blog.entity.PostEntity;

public interface BlogDao extends JpaRepository<PostEntity, Integer> {

}
