package com.pradeep.orderservice.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import com.pradeep.orderservice.security.JwtAuthenticationFilter;
import com.pradeep.orderservice.security.JwtService;
import com.pradeep.orderservice.service.CustomUserDetailsService;

import lombok.RequiredArgsConstructor;


@Configuration
@EnableWebSecurity
@RequiredArgsConstructor
public class SecurityConfig {
	
	private final CustomUserDetailsService customUserDetailsService;
	
	@Bean
	SecurityFilterChain securityFilterChanin(HttpSecurity http, JwtAuthenticationFilter jwtAuthenticationFilter) throws Exception{

		return http
				.csrf(csrf -> csrf.disable()).authorizeHttpRequests(auth -> auth.requestMatchers("/actuator/health","/api/orders/health", "/api/auth/login")
						.permitAll().anyRequest().authenticated()).addFilterBefore(
					            jwtAuthenticationFilter,
					            UsernamePasswordAuthenticationFilter.class)
				.build();

	}
	
	@Bean
	JwtAuthenticationFilter jwtAuthenticationFilter(
	        JwtService jwtService) {

	    return new JwtAuthenticationFilter(jwtService, customUserDetailsService);
	}
	
	/*
	 * @Bean UserDetailsService userServiceDetails(PasswordEncoder passwordEncoder)
	 * {
	 * 
	 * return customUserDetailsService; }
	 */

	@Bean
	PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
	
	@Bean
    AuthenticationManager authenticationManager(
            AuthenticationConfiguration configuration) throws Exception {

        return configuration.getAuthenticationManager();
    }

}
