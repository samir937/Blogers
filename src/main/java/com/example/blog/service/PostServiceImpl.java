package com.example.blog.service;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.example.blog.dao.CategoryRepo;
import com.example.blog.dao.PostRepo;
import com.example.blog.dao.UserRepo;
import com.example.blog.entity.Category;
import com.example.blog.entity.Post;
import com.example.blog.entity.User;
import com.example.blog.exception.ResourceNotFoundException;
import com.example.blog.payload.ApiResponse;
import com.example.blog.payload.PostDto;
import com.example.blog.payload.PostResponse;

@Service
public class PostServiceImpl implements PostService {

	@Autowired
	private PostRepo postRepo;
	
	@Autowired
	private UserRepo userRepo;
	
	@Autowired
	private CategoryRepo categoryRepo;
	
	@Autowired
	private ModelMapper modelMapper;
	

	@Override
	public PostDto createPost(PostDto postDto, Integer userId, Integer categoryId) {
		// TODO Auto-generated method stub
		
		User user=userRepo.findById(userId).orElseThrow(()-> new ResourceNotFoundException("User", "id", userId));
		Category category=categoryRepo.findById(categoryId).orElseThrow(()-> new ResourceNotFoundException("Category", "cat_id", categoryId));
		
		Post post=modelMapper.map(postDto, Post.class);
		post.setPostImage("default.img");
		post.setAddedDate(new Date());
		post.setUser(user);
		post.setCategory(category);
		
		Post newPost=postRepo.save(post);
	
		return modelMapper.map(newPost, PostDto.class);
	}


	@Override
	public PostDto updatePost(int id, PostDto postDto) {
		// TODO Auto-generated method stub
		Post post=postRepo.findById(id).orElseThrow(()->new ResourceNotFoundException("Post" ,"postId", id));
		post.setPostTitle(postDto.getPostTitle());
		post.setContent(postDto.getContent());
		post.setPostImage(postDto.getPostImage());
		
		Post updatePost=postRepo.save(post);
		
		return modelMapper.map(updatePost, PostDto.class);
	}


	@Override
	public ApiResponse deletePost(int id) {
		// TODO Auto-generated method stub
		postRepo.deleteById(id);		
		return new ApiResponse("User Deleted Successfully !!!",true);
	}


	@Override
	public PostResponse getAllPost(Integer pageNumber,Integer pageSize) {
		// TODO Auto-generated method stub
				
		Pageable pageable=PageRequest.of(pageNumber, pageSize);
		Page<Post> page= postRepo.findAll(pageable);
		List<Post> posts=page.getContent();
		List<PostDto> allposts=posts.stream().map(e->modelMapper.map(e, PostDto.class)).collect(Collectors.toList());
		
		PostResponse postResponse =new PostResponse();
		postResponse.setContent(allposts);
		postResponse.setPageNumber(pageNumber);
		postResponse.setPageSize(pageSize);
		postResponse.setTotalPages(page.getTotalPages());
		postResponse.setTotalElements(page.getTotalElements());
		postResponse.setLastPage(page.isLast());
		
		
		return postResponse;
	}


	@Override
	public PostDto getPostById(int id) {
		// TODO Auto-generated method stub
		
		Post post=postRepo.findById(id).orElseThrow(()-> new ResourceNotFoundException("Post", "postId", id));
		return modelMapper.map(post,PostDto.class);
	}


	@Override
	public List<PostDto> getPostsByUser(int userId) {
		// TODO Auto-generated method stub
		User user=userRepo.findById(userId).orElseThrow(()-> new ResourceNotFoundException("User", "id", userId));
		List<Post> posts=postRepo.findByUser(user);
		List<PostDto> allposts=posts.stream().map(e-> modelMapper.map(e, PostDto.class)).collect(Collectors.toList());
		return allposts;
	}


	@Override
	public List<PostDto> getPostsByCategory(int categoryId) {
		// TODO Auto-generated method stub
	
		Category category=categoryRepo.findById(categoryId).orElseThrow(()->new ResourceNotFoundException("Category","cat_id", categoryId));
		List<Post> posts=postRepo.findByCategory(category);
		List<PostDto> postDo=posts.stream().map(e->modelMapper.map(e, PostDto.class)).collect(Collectors.toList());
		return postDo;
	}


	

}
