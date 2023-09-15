package com.app.pojo;


import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
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
@Table(name="Outlet")
public class Outlet {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long outletd;
     
	@Column(name="name",length=20)
	private String name;
	
	@Column(name="address",length=20)
	private String address;
	
	@Column(name="contact_no",length=20)
	private String contactNo;
	
	@Column(name="licence_no",length=20)
	private String licenceNo;
	
	@Column(name="created_at")
	@CreationTimestamp
	private LocalDateTime createdAt;

	@Column(name="modified_at")
	@UpdateTimestamp
	private LocalDateTime modifieAt;
	
	//@OneToMany(mappedBy="outlet")
	//List<User>user=new ArrayList<>();

	
}
