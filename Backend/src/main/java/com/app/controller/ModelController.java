package com.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.app.pojo.Model;
import com.app.service.ModelService;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/model")
public class ModelController {

	@Autowired
	private ModelService service;
	
	@GetMapping("/{id}")
	public List<Model> getModelByManufacId(@PathVariable Long id)
	{
		return service.getModelByManufacId(id);
	}
	
//	@GetMapping("/{name}")
//	public List<String> getModelByManufacId(@PathVariable String name)
//	{
//		return service.getModelByManufacId(name);
//	}
	
}
