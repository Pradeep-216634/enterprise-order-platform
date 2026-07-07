package com.pradeep.orderservice.service;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import com.pradeep.orderservice.security.JwtService;


@Service
public class JwtUtil implements JwtService{
	
	private final JwtProperties jwtProperties;

	@Override
	public String generateToken(UserDetails userDetails) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String extractUsername(String token) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean isTokenValid(String token, UserDetails userDetails) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isTokenExpired(String token) {
		// TODO Auto-generated method stub
		return false;
	}

}
