package com.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.dao.UsersDao;
import com.app.dto.Credentials;
import com.app.pojo.AuthenticationResponse;
import com.app.pojo.Outlet;
import com.app.pojo.Users;
import com.app.security.JwtUtil;
import com.app.service.UsersService;


@CrossOrigin("*")
@RestController
@RequestMapping("/users")
public class AuthController {
	
	@Autowired
	private UsersService usersService;
	@Autowired
	private AuthenticationManager authManager;
	@Autowired
	private JwtUtil jwtUtil;

	@PostMapping("/Login")
	public ResponseEntity<?> authenticate(@RequestBody Credentials cred) {
	    try {
	        // authenticate user with authentication manager
	        Authentication auth = new UsernamePasswordAuthenticationToken(cred.getEmail(), cred.getPasswd());
	        System.out.println("BEFORE AUTH: " + auth);
	        System.out.println("Email - "+cred.getEmail());
	        System.out.println("Password - "+cred.getPasswd());
	        auth = authManager.authenticate(auth);
	        System.out.println("AFTER AUTH: " + auth);
	        // after authentication, create JWT token and return along with the user information
	        String token = jwtUtil.createToken(auth);
	        System.out.println("AFTER GETTING TOKEN: " + token);
	        // Retrieve user information from the service
	        Users user = usersService.getUserInfo(cred.getEmail());
	        System.out.println("AFTER GETTING USER : " + user);
	        // Create the response object with token and user information
	        AuthenticationResponse response = new AuthenticationResponse(token, user);

	        return ResponseEntity.ok(response);
	    } catch (BadCredentialsException e) {
	        e.printStackTrace();
	        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(e.getMessage());
	    } catch (Exception e) {
	        e.printStackTrace();
	        return ResponseEntity.internalServerError().body(e.getMessage());
	    }
	}
	
	@Autowired
	private PasswordEncoder passwordEncoder;
	@Autowired
	private UsersDao userDao;
	
	@PostMapping("/SignUp")
	public Users registerUser(@RequestBody Users cred) {
		String encPassword = passwordEncoder.encode(cred.getPassword());
//		Users user = new Users(0, cred.getEmail(), encPassword, 1, null, "ROLE_USER");
		Users user = new Users(0L,cred.getFname(),cred.getLname(),"ROLE_CUSTOMER",cred.getEmail(),encPassword,cred.getOutlet());
		userDao.save(user);
		return user;
	}
}
























//package com.app.controller;
//
//import java.util.Optional;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.CrossOrigin;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.PathVariable;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.PutMapping;
//import org.springframework.web.bind.annotation.RequestBody;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestParam;
//import org.springframework.web.bind.annotation.RestController;
//
//import com.app.dto.Password;
//import com.app.pojo.Users;
//import com.app.service.UsersService;
//
//@CrossOrigin(origins = "*")
//@RestController
//@RequestMapping("/users")
//public class UsersController {
//	
//	@Autowired
//	private UsersService service;
//	
//	@PutMapping("/update/{newPass}/{oldPass}")
//	public int updatePass(@PathVariable String newPass,
//			@PathVariable String oldPass) {
//		return service.updatePass(newPass, oldPass);
//	}
//	
//	@PostMapping("/SignUp")
//	public ResponseEntity<?> signup(@RequestBody Users user)
//	{
//		System.out.println(user);
//		return new ResponseEntity<>(service.addUserDetails(user),HttpStatus.OK);
//	}
//
//	
//	@PostMapping("/Login")
//	public ResponseEntity<?> logIn(@RequestBody Password password)
//	{
//		System.out.println(password);
//		return new ResponseEntity<>(service.logIn(password.getEmail(), password.getPassword()),HttpStatus.OK);
//	}
//	
//	 
//}
