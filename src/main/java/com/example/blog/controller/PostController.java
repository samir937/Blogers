package com.example.blog.controller;

import java.util.List;

import javax.validation.Valid;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.blog.entity.Post;
import com.example.blog.payload.ApiResponse;
import com.example.blog.payload.PostDto;
import com.example.blog.payload.PostResponse;
import com.example.blog.service.PostService;

import net.bytebuddy.implementation.bytecode.constant.DefaultValue;

@RestController
@RequestMapping("/api/")
public class PostController {
	
	@Autowired
	private PostService postService;
	
	
	@PostMapping("/user/{userId}/category/{categoryId}/posts")
	public ResponseEntity<PostDto> createPost(
			@Valid @RequestBody PostDto postDto,
			@PathVariable("userId") Integer userId,
			@PathVariable("categoryId") Integer categoryId	
			)
	{
		PostDto newPost= postService.createPost(postDto, userId, categoryId);
	
		return new ResponseEntity<PostDto>(newPost,HttpStatus.CREATED);
	}
	
	@GetMapping("/allPosts")
	public ResponseEntity<PostResponse> allPost(
			@RequestParam(value ="pageNumber" ,defaultValue ="0",required = false) Integer pageNumber
			,@RequestParam(value ="pageSize" ,defaultValue = "10",required = false) Integer pageSize)
	{
		PostResponse postResponse=postService.getAllPost(pageNumber,pageSize);
		return new ResponseEntity<PostResponse>(postResponse,HttpStatus.OK);
	}
	
	@GetMapping("/post/{id}")
	public ResponseEntity<PostDto> getPostById(@PathVariable Integer id)
	{
		PostDto postDto=postService.getPostById(id);
		return new ResponseEntity<PostDto>(postDto,HttpStatus.OK);
	}
	
	@GetMapping("/user/{userId}/posts")
	public ResponseEntity<List<PostDto>> postByUser(@PathVariable Integer userId)
	{
		List<PostDto> postDto=postService.getPostsByUser(userId);
		return new ResponseEntity<List<PostDto>>(postDto,HttpStatus.OK);
	}
	
	@GetMapping("/category/{categoryId}/posts")
	public ResponseEntity<List<PostDto>> postByCategory(@PathVariable Integer categoryId)
	{
		List<PostDto> postDto=postService.getPostsByCategory(categoryId);
		return new ResponseEntity<List<PostDto>>(postDto,HttpStatus.OK);
	}
	
	@PutMapping("/user/{userId}/category/{categoryId}/updatePost/{id}")
	public ResponseEntity<PostDto> updatePost(@Valid @RequestBody PostDto postDto ,@PathVariable Integer id)
	{
		PostDto updatePost=postService.updatePost(id, postDto);
		return new ResponseEntity<PostDto>(updatePost,HttpStatus.OK);		
	}
	
	@DeleteMapping("/post/{id}")
	public ResponseEntity<ApiResponse> deleteUser(@PathVariable Integer id)
	{
		ApiResponse apiResponse=postService.deletePost(id);
		return new ResponseEntity<ApiResponse>(apiResponse,HttpStatus.OK);
	}

	
}
