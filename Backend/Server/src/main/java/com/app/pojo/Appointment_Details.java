package com.app.pojo;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Appointment_Details implements Serializable{
	
	@Id
	@ManyToOne
	@JoinColumn(name = "appointment_id")
	Appointment appointment;
	
	@Id
	@ManyToOne
	@JoinColumn(name = "service_id")
	Services service;
	
	@Id
	@ManyToOne
	@JoinColumn(name = "manfac_id")
	Manufacturer manufacturer;
	
	@Id
	@ManyToOne
	@JoinColumn(name = "model_id")
	Model model;
	
}