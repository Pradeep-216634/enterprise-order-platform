package com.pradeep.orderservice.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pradeep.orderservice.dto.LoginRequest;
import com.pradeep.orderservice.dto.LoginResponse;
import com.pradeep.orderservice.service.AuthenticationService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/auth")
@RequiredArgsConstructor
public class AuthController {
	
	private final AuthenticationService authenticationService;
	
	 @PostMapping("/login")
	 public LoginResponse login(@RequestBody LoginRequest request) {

		 return authenticationService.login(request);
	    }

}
