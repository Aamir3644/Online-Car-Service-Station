package com.app.dao;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import com.app.pojo.Outlet;
import com.app.pojo.Users;

public interface UsersDao extends JpaRepository<Users,Long>{

	@Modifying
	@Query(value="update users set password=?1 where password=?2 ", nativeQuery = true)
	public int updatePassword(String newPass, String oldPass);
	
	@Query("SELECT u FROM Users u WHERE u.email = ?1 AND u.password = ?2")
	public Optional<Users> logIn(String email,String password);
	
	Users findByEmail(String email);
	
}
