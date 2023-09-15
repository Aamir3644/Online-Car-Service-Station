package com.app.pojo;
import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
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
@Table(name="Services")
public class Services {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long serviceId;
	
	@Column(name="name",length=20)
	private String description;
    
	@Column(name="price")
	private int price;
	
	@Column(name="duration",length=20)
	private String duration;
	
	@Column(name="created_at")
	@CreationTimestamp
	private LocalDateTime createdAt;
	
	@Column(name="modified_at")
	@UpdateTimestamp
	private LocalDateTime modifiedAt;

}
