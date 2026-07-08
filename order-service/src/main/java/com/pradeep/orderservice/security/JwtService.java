package com.pradeep.orderservice.security;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import com.pradeep.orderservice.config.JwtProperties;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class JwtService {
	
	private final JwtProperties jwtProperties;

	public String generateToken(UserDetails userDetails) {
		// TODO Auto-generated method stub
		return null;
	}

	public String extractUsername(String token) {
		// TODO Auto-generated method stub
		return null;
	}

	public boolean isTokenValid(String token, UserDetails userDetails) {
		// TODO Auto-generated method stub
		return false;
	}

	public boolean isTokenExpired(String token) {
		// TODO Auto-generated method stub
		return false;
	}

}
