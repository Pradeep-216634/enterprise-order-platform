package com.pradeep.orderservice.security;

import org.springframework.security.core.userdetails.UserDetails;

public interface JwtService {
	
	public String generateToken(UserDetails userDetails);

	public String extractUsername(String token);

	public boolean isTokenValid(String token, UserDetails userDetails);

	public boolean isTokenExpired(String token);

}
