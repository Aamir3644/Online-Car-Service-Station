package com.app.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.app.dao.ModelDao;
import com.app.pojo.Model;

@Service
@Transactional
public class ModelService {

	@Autowired
	private ModelDao dao;
	
	public List<String> getModelByManufacId(String name)
	{
		return dao.getModelByManufacId(name);
	}
}
