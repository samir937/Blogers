package com.example.blog.service;

import com.example.blog.payload.JwtRequest;

public interface JwtService {

	public String generateToken(JwtRequest jwtRequest)  throws Exception ;
}
