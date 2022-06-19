package com.example.blog.exception;

import com.example.blog.entity.User;

import lombok.Data;
import lombok.Getter;

@Data
public class ResourceNotFoundException extends RuntimeException {   //to make unchecked exception

	private String resourceName;
	private String fieldName;
	private long fieldValue;
	
	public ResourceNotFoundException(String resourceName, String fieldName, long fieldValue) {
		super(String.format("%s not found with %s : %l",resourceName,fieldName,fieldValue));
		this.resourceName = resourceName;
		this.fieldName = fieldName;
		this.fieldValue = fieldValue;
	}

	
	
	
	
	
	
	
}
