package com.app.security;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

@Component
public class JwtFilter extends OncePerRequestFilter {
	@Autowired
	private JwtUtil jwtUtil;
	
	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
			throws ServletException, IOException {
		// PRE-PROCESSING
		// get jwt token from request header
		String authHeader = request.getHeader("Authorization");
		boolean validHeader = authHeader != null && authHeader.startsWith("Bearer");
		Authentication auth = null;
		if (validHeader) {
			String token = authHeader.replace("Bearer", "").trim();
			// validate that jwt token and create Authentication object
			auth = jwtUtil.validateToken(token);
		}
		
		//  attach auth/principal to current security context
		if (auth != null && SecurityContextHolder.getContext().getAuthentication() == null)
			SecurityContextHolder.getContext().setAuthentication(auth);
		
		// invoke next filter in the chain
		filterChain.doFilter(request, response);
		
		// POST-PROCESSING (nothing to do here)
	}
}
