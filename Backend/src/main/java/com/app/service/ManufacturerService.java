package com.app.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.app.dao.ManufacturerDao;
import com.app.dao.PaymentsDao;
import com.app.pojo.Manufacturer;
import com.app.pojo.Services;

@Service
@Transactional
public class ManufacturerService {

	@Autowired
	private ManufacturerDao dao;
	
	public List<Manufacturer> getAllManufacturer(){
		System.out.println("in manufacturer layer");
		return dao.findAll();
	}
}
