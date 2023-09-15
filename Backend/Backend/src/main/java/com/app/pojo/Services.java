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

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name="Services")
public class Services {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long serviceId;
	
	@Column(name="name", length=20)
	private String name;
	
	@Column(name="description",length=20)
	private String description;
    
	@Column(name="price")
	private int price;
	
	@Column(name="duration",length=20)
	private String duration;
	
	
	public Services() {
			System.out.println("in services ctor");
	}

	public Services(String name, String description, int price, String duration) {
		super();
		this.name = name;
		this.description = description;
		this.price = price;
		this.duration = duration;
	}

	public Long getServiceId() {
		return serviceId;
	}

	public void setServiceId(Long serviceId) {
		this.serviceId = serviceId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public String getDuration() {
		return duration;
	}

	public void setDuration(String duration) {
		this.duration = duration;
	}

	@Override
	public String toString() {
		return "Services [serviceId=" + serviceId + ", name=" + name + ", description=" + description + ", price="
				+ price + ", duration=" + duration + "]";
	}

	
}
