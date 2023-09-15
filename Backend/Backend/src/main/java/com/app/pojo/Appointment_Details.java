package com.app.pojo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="appointment_details")
public class Appointment_Details{
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="appointment_details_id")
	private Long appointmentDetailsId;
	
	@ManyToOne
	@JoinColumn(name = "appointment_id")
	private Appointment appointment;
	
	@ManyToOne
	@JoinColumn(name = "service_id")
	private Services service;
	
	
	public Appointment_Details() {
		
	}


	public Appointment_Details(Appointment appointment, Services service) {
		super();
		this.appointment = appointment;
		this.service = service;
	}


	public Long getAppointmentDetailsId() {
		return appointmentDetailsId;
	}


	public void setAppointmentDetailsId(Long appointmentDetailsId) {
		this.appointmentDetailsId = appointmentDetailsId;
	}


	public Appointment getAppointment() {
		return appointment;
	}


	public void setAppointment(Appointment appointment) {
		this.appointment = appointment;
	}


	public Services getService() {
		return service;
	}


	public void setService(Services service) {
		this.service = service;
	}

	
	
	
}
