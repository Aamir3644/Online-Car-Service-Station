package com.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.pojo.Outlet;
import com.app.pojo.Services;
import com.app.service.OutletService;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/outlet")
public class OutletController {
	
	@Autowired
	private OutletService service;
	
	@GetMapping
	public List<Outlet> allServices()
	{
		System.out.println("in get all outlet - CONTROLLER");
		return service.getAllOutlets();
	}
}
