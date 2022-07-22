package com.example.blog.controller;

import org.apache.catalina.connector.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.blog.payload.JwtRequest;
import com.example.blog.payload.JwtResponse;
import com.example.blog.service.JwtService;

@RestController
@RequestMapping("/security")
public class SecurityController {
	
	@Autowired
	private JwtService jwtService;

	
	@PostMapping("/token")
	public ResponseEntity<JwtResponse> generateToken(@RequestBody JwtRequest jwtRequest) throws Exception
	{
		String token=jwtService.generateToken(jwtRequest);
		
		return new ResponseEntity<>(new JwtResponse(token),HttpStatus.OK);
	}
}
