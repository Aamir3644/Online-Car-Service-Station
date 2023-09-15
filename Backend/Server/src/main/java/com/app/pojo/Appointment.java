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

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name="Appointment")
public class Appointment {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="appointment_id")
	private Long appointmentId;
	
    @Column(name="appointment")
    @CreationTimestamp
    private LocalDateTime appointment;
    
    @Column(name="status")
    private Boolean status;
    
    @Column(name="created_at")
    @CreationTimestamp
	private LocalDateTime createdAt;
    
    @Column(name="modified_at")
    @UpdateTimestamp
    private LocalDateTime modifiedAt;
    
    @ManyToOne
    @JoinColumn(name="user_id")
    private Users user;
    
    @ManyToOne
    @JoinColumn(name="outlet_id")
    private Outlet outlet;

}
