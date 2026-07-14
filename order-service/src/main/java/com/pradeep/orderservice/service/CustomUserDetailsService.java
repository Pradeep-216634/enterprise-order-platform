package com.pradeep.orderservice.service;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.pradeep.orderservice.entity.User;
import com.pradeep.orderservice.repository.UserRepository;
import com.pradeep.orderservice.security.UserPrincipal;

import org.springframework.security.core.authority.SimpleGrantedAuthority;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class CustomUserDetailsService implements UserDetailsService{
	
	private final UserRepository repository;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		System.out.println("Loading user: " + username);
		User user = repository.findByUsername(username)
                .orElseThrow(() ->
                        new UsernameNotFoundException("User not found: " + username));
		
		System.out.println("Loaded roles: " + user.getRoles());

		return new UserPrincipal(
		        user.getId(),
		        user.getUsername(),
		        user.getPassword(),
		        user.getEnabled(),
		        user.getRoles()
		            .stream()
		            .map(role -> new SimpleGrantedAuthority(role.getName()))
		            .toList());
    }

}
