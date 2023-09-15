package com.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.pojo.Manufacturer;
import com.app.pojo.Services;
import com.app.service.ManufacturerService;


@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/manufacturer")
public class ManufacturerController {

	@Autowired
	private ManufacturerService service;
	
	@GetMapping
	public List<Manufacturer> allManufacturers()
	{
		System.out.println("in get all emps - CONTROLLER");
		return service.getAllManufacturer();
	}
	
}
