package com.app.pojo;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.apache.catalina.User;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name="Reviews")
public class Reviews {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="review_id")
	private Long reviewId;

	@Column(name="rating")
	private float rating;
	
	@Column(name="comment")
	private String comment;
	
	@Column(name="created_at")
	@CreationTimestamp
	private LocalDateTime createdAt;
	
	@Column(name="modiified_at")
	@UpdateTimestamp
	private LocalDateTime modifiedAt;
	
	@ManyToOne
	@JoinColumn(name="customer_id")
	private Users user;
	
	@ManyToOne
	@JoinColumn(name="outlet_id")
	private Outlet outlet;
	
	@ManyToOne
	@JoinColumn(name="appointment_id")
	private Appointment appointment;
	
	
}
