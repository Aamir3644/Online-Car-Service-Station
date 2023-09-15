package com.app.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.app.dao.OutletDao;
import com.app.pojo.Outlet;
import com.app.pojo.Services;

@Service
@Transactional
public class OutletService {

	@Autowired
	private OutletDao dao;
	
	public List<Outlet> getAllOutlets(){
		System.out.println("in outlet layer");
		return dao.findAll();
	}
}
