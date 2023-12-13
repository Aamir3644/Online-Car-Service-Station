package com.app.pojo;

import java.time.LocalDate;

import java.time.LocalTime;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;



@Entity
@Table(name="Appointment")
public class Appointment {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="appointment_id")
	private Long appointmentId;
	
    @Column(name="appointment_date")
    private LocalDate appointmentDate;
    
    @Column(name="appointment_time")
    private LocalTime appointmentTime;
    
    @Column(name="status")
    private Boolean status;
    
    @ManyToOne
    @JoinColumn(name="user_id")
    private Users user;
    
    @ManyToOne
    @JoinColumn(name="outlet_id")
    private Outlet outlet;
    

	@ManyToOne
	@JoinColumn(name = "manfac_id")
	private Manufacturer manufacturer;
	
	@ManyToOne
	@JoinColumn(name = "model_id")
	private Model model;
    
    public Appointment() {
    	
    }

	public Appointment(LocalDate appointmentDate, LocalTime appointmentTime, Boolean status, Users user, Outlet outlet,
			Manufacturer manufacturer, Model model) {
		super();
		this.appointmentDate = appointmentDate;
		this.appointmentTime = appointmentTime;
		this.status = status;
		this.user = user;
		this.outlet = outlet;
		this.manufacturer = manufacturer;
		this.model = model;
	}

	public Long getAppointmentId() {
		return appointmentId;
	}

	public void setAppointmentId(Long appointmentId) {
		this.appointmentId = appointmentId;
	}

	public LocalDate getAppointmentDate() {
		return appointmentDate;
	}

	public void setAppointmentDate(LocalDate appointmentDate) {
		this.appointmentDate = appointmentDate;
	}

	public LocalTime getAppointmentTime() {
		return appointmentTime;
	}

	public void setAppointmentTime(LocalTime appointmentTime) {
		this.appointmentTime = appointmentTime;
	}

	public Boolean getStatus() {
		return status;
	}

	public void setStatus(Boolean status) {
		this.status = status;
	}

	public Users getUser() {
		return user;
	}

	public void setUser(Users user) {
		this.user = user;
	}

	public Outlet getOutlet() {
		return outlet;
	}

	public void setOutlet(Outlet outlet) {
		this.outlet = outlet;
	}

	public Manufacturer getManufacturer() {
		return manufacturer;
	}

	public void setManufacturer(Manufacturer manufacturer) {
		this.manufacturer = manufacturer;
	}

	public Model getModel() {
		return model;
	}

	public void setModel(Model model) {
		this.model = model;
	}
    
    

    
    

}
