package com.example.blog.controller;

import java.util.List;

import javax.validation.Valid;

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
import org.springframework.web.bind.annotation.RestController;

import com.example.blog.payload.ApiResponse;
import com.example.blog.payload.CategoryDto;
import com.example.blog.service.CategoryService;

@RestController
@RequestMapping("/api/category")
public class CategoryController {

	@Autowired
	private CategoryService categoryService;
	
//addCategory
	@PostMapping("/createCategory")
	public ResponseEntity<CategoryDto> createCategory(@Valid @RequestBody CategoryDto categoryDto)
	{
		CategoryDto newCat=categoryService.createCategory(categoryDto);
		return new ResponseEntity<CategoryDto>(newCat,HttpStatus.CREATED);
	}
	
//getAllCategory
	@GetMapping("/allCategory")
	public ResponseEntity<List<CategoryDto> > getAllCategory()
	{
		List<CategoryDto> allCategory=categoryService.getAllCategory();
		return new ResponseEntity<List<CategoryDto> >(allCategory,HttpStatus.OK);
	}
	
//getCategoryById
	@GetMapping("/{id}")
	public ResponseEntity<CategoryDto> getCategoryById(@PathVariable Integer id)
	{
		CategoryDto newCat=categoryService.getCategoryById(id);
		return new ResponseEntity<CategoryDto>(newCat,HttpStatus.CREATED);
	}
	
	
//updateCategory
	@PutMapping("/{id}")
	public ResponseEntity<CategoryDto> updateCategory(@Valid @RequestBody CategoryDto categoryDto,@PathVariable Integer id)
	{
		CategoryDto newCat=categoryService.updateCategory(id, categoryDto);
		return new ResponseEntity<CategoryDto>(newCat,HttpStatus.CREATED);
	}

//deleteCategory	
	@DeleteMapping("/{id}")
	public ResponseEntity<ApiResponse> deleteCategory(@PathVariable Integer id)
	{
		categoryService.deleteCategory(id);
		return new ResponseEntity<ApiResponse>(new ApiResponse("Category deleted successfully !!!",true),HttpStatus.OK);
	}
	
}
