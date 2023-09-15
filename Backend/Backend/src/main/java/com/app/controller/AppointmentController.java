package com.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.pojo.Appointment;
import com.app.service.AppointmentService;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/appointment")
public class AppointmentController {

	@Autowired
	private AppointmentService service;
	
	@GetMapping("/{uid}")
	public List<Appointment> appointmentById(@PathVariable Long uid){
		return service.getAppointmentById(uid);
	}
}
