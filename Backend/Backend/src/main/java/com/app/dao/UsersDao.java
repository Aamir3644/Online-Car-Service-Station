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
	
	@Query("select new com.app.pojo.Users (userId,fname, lname, role) from Users u where u.email=?1 and u.password=?2")
	public Optional<Users> logIn(String email,String password);
	
//	@Query(value="select fname,lname,role from users where email=?1", nativeQuery = true)
//	public Users userByEmail(String email);
}
