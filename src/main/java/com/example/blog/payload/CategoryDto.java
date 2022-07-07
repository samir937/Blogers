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
	
}
