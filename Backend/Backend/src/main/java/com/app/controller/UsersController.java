package com.app.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.app.dto.Password;
import com.app.pojo.Users;
import com.app.service.UsersService;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/users")
public class UsersController {
	
	@Autowired
	private UsersService service;
	
	@PutMapping("/update/{newPass}/{oldPass}")
	public int updatePass(@PathVariable String newPass,
			@PathVariable String oldPass) {
		return service.updatePass(newPass, oldPass);
	}
	
	@PostMapping("/SignUp")
	public ResponseEntity<?> signup(@RequestBody Users user)
	{
		System.out.println(user);
		return new ResponseEntity<>(service.addUserDetails(user),HttpStatus.OK);
	}
	
//	@PostMapping("/Login")
//	public Optional<Users> logIn(@RequestBody Password password){
//		return service.logIn(password.getEmail(), password.getPassword());
//	}
	
	@PostMapping("/Login")
	public ResponseEntity<?> logIn(@RequestBody Password password)
	{
		System.out.println(password);
		return new ResponseEntity<>(service.logIn(password.getEmail(), password.getPassword()),HttpStatus.OK);
	}
}
