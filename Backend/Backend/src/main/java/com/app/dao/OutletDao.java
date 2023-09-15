package com.app.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.app.pojo.Outlet;

public interface OutletDao extends JpaRepository<Outlet, Long>{
	
}
