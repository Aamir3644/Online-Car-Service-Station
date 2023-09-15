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
@Getter
@Setter
@NoArgsConstructor
public class Payments {

	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="payment_id")
	private Long paymentId;
	
	@Column(name="total")
	private float total;
	
	@Column(name="payment_date")
	private LocalDateTime paymentDate;
	
	@Column(name="created_at")
    @CreationTimestamp
	private LocalDateTime createdAt;
	
	@Column(name="modified_at")
	@UpdateTimestamp
	private LocalDateTime modifiedAt;
	
	@ManyToOne
	@JoinColumn(name = "appointment_id")
	Appointment appointment;

}
