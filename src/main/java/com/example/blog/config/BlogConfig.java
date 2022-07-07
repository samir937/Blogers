package com.example.blog.config;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.example.blog.payload.ApiResponse;

@Configuration
public class BlogConfig {

	@Bean 
	public ApiResponse getApiBean()
	{
		return new ApiResponse();
	}
	
	@Bean 
	public ModelMapper getModelMapperBean()
	{
		return new ModelMapper();
	}
	
}
