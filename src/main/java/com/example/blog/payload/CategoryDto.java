package com.example.blog.payload;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class CategoryDto {

	private int categoryId;
	
	@NotEmpty
	@Size(min=5,max=20,message="Title should be of min 5 chars and max 20 chars")
	private String categoryTitle;
	@NotEmpty
	@Size(min=5,max=100,message="Description should be of min 5 chars and max 50 chars")
	private String categoryDescription;
	
	public CategoryDto(int categoryId,
			@NotEmpty @Size(min = 5, max = 20, message = "Title should be of min 5 chars and max 20 chars") String categoryTitle,
			@NotEmpty @Size(min = 5, max = 100, message = "Description should be of min 5 chars and max 50 chars") String categoryDescription) {
		super();
		this.categoryId = categoryId;
		this.categoryTitle = categoryTitle;
		this.categoryDescription = categoryDescription;
	}

	public int getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(int categoryId) {
		this.categoryId = categoryId;
	}

	public String getCategoryTitle() {
		return categoryTitle;
	}

	public void setCategoryTitle(String categoryTitle) {
		this.categoryTitle = categoryTitle;
	}

	public String getCategoryDescription() {
		return categoryDescription;
	}

	public void setCategoryDescription(String categoryDescription) {
		this.categoryDescription = categoryDescription;
	}
	
	
	
	
	
}
