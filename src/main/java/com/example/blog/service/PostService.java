package com.example.blog.service;

import java.util.List;

import com.example.blog.entity.Post;
import com.example.blog.payload.ApiResponse;
import com.example.blog.payload.CategoryDto;
import com.example.blog.payload.PostDto;
import com.example.blog.payload.PostResponse;

public interface PostService {

	PostDto createPost(PostDto post,Integer userId,Integer categoryId);
	PostDto updatePost(int id,PostDto post);
	ApiResponse deletePost(int id);
	PostResponse getAllPost(Integer pageNumber,Integer pageSize);
	PostDto getPostById(int id);
	List<PostDto> getPostsByUser(int userId);
	List<PostDto> getPostsByCategory(int categoryId);
	
}
