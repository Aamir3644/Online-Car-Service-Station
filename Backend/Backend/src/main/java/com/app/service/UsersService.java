package com.app.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.app.dao.UsersDao;
import com.app.pojo.Users;

@Service
@Transactional
public class UsersService {

	@Autowired
	private UsersDao dao;
	
	public int updatePass(String newPass,String oldPass) {
		return dao.updatePassword(newPass, oldPass);
	}
	
	public Users addUserDetails(Users cust) {
		return dao.save(cust);
	}
	
	public Optional<Users> logIn(String email,String password){
		return dao.logIn(email, password);
	}
	
//	public Users userByEmail(String email) {
//		return dao.userByEmail(email);
//	}
}
