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
	
	public Appointment bookAppointment(Appointment appointment) {
    
        return dao.save(appointment);
}
	
	public List<Appointment> getAppointmentByOutletId(Long id){
		return dao.getAppointmentByOutletId(id);
	}
	
	public void updateAppointmentStatus(Long appointmentId, boolean status) {
        Appointment appointment = dao.findById(appointmentId).orElse(null);
        if (appointment != null) {
            appointment.setStatus(status);
        }
    }
	
}
