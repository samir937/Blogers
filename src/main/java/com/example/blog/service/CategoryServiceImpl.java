package com.example.blog.service;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.blog.dao.CategoryRepo;
import com.example.blog.entity.Category;
import com.example.blog.exception.ResourceNotFoundException;
import com.example.blog.payload.CategoryDto;
import com.example.blog.service.CategoryService;

@Service
public class CategoryServiceImpl implements CategoryService {

	@Autowired
	private CategoryRepo categoryRepo;
	
	@Autowired
	private ModelMapper modelMapper;

	@Override
	public CategoryDto createCategory(CategoryDto cateogry) {
		// TODO Auto-generated method stub
		
		Category newCategory=modelMapper.map(cateogry, Category.class);
		categoryRepo.save(newCategory);
		return modelMapper.map(newCategory, CategoryDto.class);
	}

	@Override
	public CategoryDto updateCategory(int id, CategoryDto cateogrydto) {
		// TODO Auto-generated method stub
		Category category=categoryRepo.findById(id).orElseThrow(()-> new ResourceNotFoundException("Category","category_id", id));
		category.setCategoryTitle(cateogrydto.getCategoryTitle());
		category.setCategoryDescription(cateogrydto.getCategoryDescription());
		
		categoryRepo.save(category);
		
		return modelMapper.map(category, CategoryDto.class);
	}

	@Override
	public void deleteCategory(int id) {
		// TODO Auto-generated method stub
		
		Category category=categoryRepo.findById(id).orElseThrow(
				()-> new ResourceNotFoundException("Category", "category_id", id));
		
		categoryRepo.deleteById(id);
		
	}

	@Override
	public List<CategoryDto> getAllCategory() {
		// TODO Auto-generated method stub
		
		List<Category> allCategory=categoryRepo.findAll();
		List<CategoryDto> allCategoryDto=allCategory.stream().map(e->modelMapper.map(e, CategoryDto.class))
										.collect(Collectors.toList());
		
		return allCategoryDto;
	}

	@Override
	public CategoryDto getCategoryById(int id) {
		// TODO Auto-generated method stub
		
		Category category=categoryRepo.findById(id).orElseThrow(
						()-> new ResourceNotFoundException("Category", "Category_id", id));
		
		return modelMapper.map(category, CategoryDto.class);
	}
	

}
