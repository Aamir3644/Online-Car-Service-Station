package com.app.pojo;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
public class Payments {

	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="payment_id")
	private Long paymentId;
	
	@Column(name="total")
	private float total;
	
	@Column(name="payment_date")
	private LocalDateTime paymentDate;
	
	@ManyToOne
	@JoinColumn(name = "appointment_id")
	private Appointment appointment;
	
	@ManyToOne
	@JoinColumn(name="outlet_id")
	private Outlet outlet;
	
	public Payments() {
		
	}

	public Payments(float total, LocalDateTime paymentDate, Appointment appointment) {
		super();
		this.total = total;
		this.paymentDate = paymentDate;
		this.appointment = appointment;
	}

	public Long getPaymentId() {
		return paymentId;
	}

	public void setPaymentId(Long paymentId) {
		this.paymentId = paymentId;
	}

	public float getTotal() {
		return total;
	}

	public void setTotal(float total) {
		this.total = total;
	}

	public LocalDateTime getPaymentDate() {
		return paymentDate;
	}

	public void setPaymentDate(LocalDateTime paymentDate) {
		this.paymentDate = paymentDate;
	}

	public Appointment getAppointment() {
		return appointment;
	}

	public void setAppointment(Appointment appointment) {
		this.appointment = appointment;
	}

	
}
