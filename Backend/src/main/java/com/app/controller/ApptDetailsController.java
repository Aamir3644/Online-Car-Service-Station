//package com.app.controller;
//
//import java.util.List;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.web.bind.annotation.CrossOrigin;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RestController;
//
//import com.app.pojo.Appointment_Details;
//import com.app.service.ApptDetailsService;
//
//@CrossOrigin(origins = "*")
//@RestController
//@RequestMapping("/appt_details")
//public class ApptDetailsController {
//
//	@Autowired
//	private ApptDetailsService service;
//	
//	@GetMapping
//	public List<Appointment_Details> allApptDetails()
//	{
//		System.out.println("in get all apptDetails - CONTROLLER");
//		return service.getAppointmentDetails();
//	}
//}
