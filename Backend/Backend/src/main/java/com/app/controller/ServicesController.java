package com.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.app.pojo.Services;
import com.app.service.ServicesService;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/services")
public class ServicesController {
	
		@Autowired
		private ServicesService service;
		
		
		@GetMapping
		public List<Services> allServices()
		{
			System.out.println("in get all services - CONTROLLER");
			return service.getAllServices();
		}

}
