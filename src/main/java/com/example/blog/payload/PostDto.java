package com.example.blog.payload;

import javax.validation.constraints.NotEmpty;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class PostDto {

	@NotEmpty(message = "postTitle cannot be empty")
	private String postTitle;
	@NotEmpty
	private String content;
	
	private String postImage;
	
	private CategoryDto category;
	
	private UserDto user;

}
