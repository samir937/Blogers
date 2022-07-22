package com.example.blog.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.example.blog.payload.JwtRequest;
import com.example.blog.utils.JwtUtils;

@Service
public class JwtServiceImpl implements JwtService {
	
	@Autowired
	private JwtUtils jwtUtils;
	
	@Autowired
	private CustomUserDetailsService customUserDetailsService;
	
	@Autowired
	private AuthenticationManager authenticationManager;

	@Override
	public String generateToken(JwtRequest jwtRequest) throws Exception {
		// TODO Auto-generated method stub
		try {
			authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(jwtRequest.getUserName(), jwtRequest.getPassword()));
			
		}
		catch(UsernameNotFoundException e)
		{
			e.printStackTrace();
			throw new Exception("Bad Credentials !!");
		}
		catch(BadCredentialsException e)
		{
			e.printStackTrace();
			throw new Exception("Bad Credentials !!");
		}
		
		UserDetails userDetails= customUserDetailsService.loadUserByUsername(jwtRequest.getUserName());
		String token=jwtUtils.generateToken(userDetails);
		return token;
	}

}
