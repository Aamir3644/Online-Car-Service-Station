package com.app.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.app.dao.AppointmentDao;
import com.app.pojo.Appointment;


@Service
@Transactional
public class AppointmentService {

	@Autowired
	private AppointmentDao dao;
	
	public List<Appointment> getAppointmentById(Long id){
		return dao.getAppointmentById(id);
	}
}
