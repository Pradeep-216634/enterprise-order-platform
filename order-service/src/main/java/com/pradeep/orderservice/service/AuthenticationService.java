package com.pradeep.orderservice.service;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;

import com.pradeep.orderservice.dto.LoginRequest;
import com.pradeep.orderservice.dto.LoginResponse;
import com.pradeep.orderservice.security.JwtService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class AuthenticationService {
	
	private final AuthenticationManager authenticationManager;
    private final UserDetailsService userDetailsService;
    private final JwtService jwtService;
	
	public LoginResponse login(LoginRequest loginRequest) {
		authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(
				loginRequest.userName(),
				loginRequest.password()
        ));
		
		UserDetails user = userDetailsService.loadUserByUsername(loginRequest.userName());

        String token = jwtService.generateToken(user);

        return new LoginResponse(token);
		
	}
	
	

}
