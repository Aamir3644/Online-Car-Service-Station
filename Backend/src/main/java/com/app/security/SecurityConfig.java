package com.app.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
public class SecurityConfig {
	@Autowired
	private UserDetailsService userDetailsService;
	@Autowired
	private JwtFilter jwtFilter;
	
	@Bean
	PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
	
	@Bean
	AuthenticationManager authenticationManager(HttpSecurity http) throws Exception {
		AuthenticationManagerBuilder authManagerBuilder = http.getSharedObject(AuthenticationManagerBuilder.class);
		authManagerBuilder.userDetailsService(userDetailsService);
		return authManagerBuilder.build();
	}
	
	@Bean
	SecurityFilterChain authorizeRequests(HttpSecurity http) throws Exception {
		http
			.csrf()
				.disable()
			.authorizeRequests()
				.antMatchers(HttpMethod.OPTIONS, "/**").permitAll()
				.antMatchers("/users/Login", "/users/SignUp", "/services","outlet","manufacturer","/model/{id}").permitAll()
				.antMatchers( "/cart" ,"/cart/{userId}","/cart/deleteItemsForUser/{userId}", "/appointment/{uid}", "/appointment").hasRole("CUSTOMER")
				.antMatchers("/appointment/outlet/{oid}", "/appointment/update-status/{appointmentId}","/payments/outlet/{outletId}").hasRole("ADMIN")
				.anyRequest().authenticated()
			.and()
			.addFilterBefore(jwtFilter, UsernamePasswordAuthenticationFilter.class)
			.sessionManagement()
				.sessionCreationPolicy(SessionCreationPolicy.STATELESS);
		return http.build();
	}
}
