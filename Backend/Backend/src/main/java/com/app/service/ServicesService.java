package com.app.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.app.dao.ServicesDao;
import com.app.pojo.Services;


@Service
@Transactional
public class ServicesService {

	@Autowired
	private ServicesDao dao;
	
	public List<Services> getAllServices(){
		System.out.println("in service layer");
		return dao.findAll();
	}
}
