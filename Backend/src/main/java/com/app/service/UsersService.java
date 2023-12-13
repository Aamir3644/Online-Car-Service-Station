package com.app.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.app.dao.UsersDao;
import com.app.pojo.Users;


@Service
@Transactional
public class UsersService implements UserDetailsService{

	@Autowired
	private UsersDao dao;
	
//	public int updatePass(String newPass,String oldPass) {
//		return dao.updatePassword(newPass, oldPass);
//	}
//	
//	public Users addUserDetails(Users cust) {
//		return dao.save(cust);
//	}
//	
//	public Optional<Users> logIn(String email,String password){
//		return dao.logIn(email, password);
//	}
//	
	
	public Users getUserInfo(String email) {
        Users optionalUser = dao.findByEmail(email);
        
        return optionalUser;
    }

	@Override
	public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
		System.out.println("Inside Load USer By Username");
		Users appUser = dao.findByEmail(email);
		System.out.println("appUser object - "+appUser);
		if(appUser == null)
			throw new UsernameNotFoundException("No user exists!");
		String role = appUser.getRole();
		//List<SimpleGrantedAuthority> authorities = List.of( new SimpleGrantedAuthority(role) );
		List<GrantedAuthority> authorities = AuthorityUtils.createAuthorityList(role);
		User user = new User(appUser.getEmail(), 
						appUser.getPassword(), 
						authorities);
		return user;
	}

}
