package com.example.blog.service;

import java.util.List;

import com.example.blog.payload.CategoryDto;


public interface CategoryService {

	 CategoryDto createCategory(CategoryDto cateogry);
	 CategoryDto updateCategory(int id,CategoryDto cateogry);
	 void deleteCategory(int id);
	 List<CategoryDto> getAllCategory();
	 CategoryDto getCategoryById(int id);

}
