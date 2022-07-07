package com.example.blog.exception;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.example.blog.payload.ApiResponse;

@RestControllerAdvice
public class GlobalExceptionHandler {

	@Autowired
	ApiResponse response;
	
	@ExceptionHandler(ResourceNotFoundException.class)
	public ResponseEntity<ApiResponse> resourceNotFoundHandler(ResourceNotFoundException res)
	{
		response.setMessage(res.getMessage());
		response.setSuccess(false);
	
		return new ResponseEntity<ApiResponse>(response,HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ResponseEntity<Map<String,String>> methodArgNotValidExceptionHandler(MethodArgumentNotValidException mex)
	{
		Map <String, String> res=new HashMap();	
		mex.getBindingResult().getAllErrors().forEach((error)->{
			String field=((FieldError)error).getField();
			String message=error.getDefaultMessage();
			res.put(field, message);
			
		});		
		return new ResponseEntity<Map<String,String>>(res,HttpStatus.BAD_REQUEST);
	}
}
