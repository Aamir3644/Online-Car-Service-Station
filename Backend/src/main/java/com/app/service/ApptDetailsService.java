//package com.app.service;
//
//import java.util.List;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//import org.springframework.transaction.annotation.Transactional;
//
//import com.app.dao.ApptDetailsDao;
//import com.app.pojo.Appointment_Details;
//
//@Service
//@Transactional
//public class ApptDetailsService {
//	
//	@Autowired
//	private ApptDetailsDao dao;
//	
//
//	public List<Appointment_Details> getAppointmentDetails(){
//		System.out.println("in appt details layer");
//		return dao.findAll();
//	}
//}
