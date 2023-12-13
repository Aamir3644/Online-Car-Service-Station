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

@Entity
@Table(name="Outlet")
public class Outlet {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long outletId;
     
	@Column(name="name",length=20)
	private String name;
	
	@Column(name="address",length=20)
	private String address;
	
	@Column(name="contact_no",length=20)
	private String contactNo;
	
	@Column(name="licence_no",length=20)
	private String licenceNo;
	
	
	public Outlet() {
		
	}

	public Outlet(String name, String address, String contactNo, String licenceNo) {
		super();
		this.name = name;
		this.address = address;
		this.contactNo = contactNo;
		this.licenceNo = licenceNo;
	}

	public Long getOutletId() {
		return outletId;
	}

	public void setOutletId(Long outletId) {
		this.outletId = outletId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getContactNo() {
		return contactNo;
	}

	public void setContactNo(String contactNo) {
		this.contactNo = contactNo;
	}

	public String getLicenceNo() {
		return licenceNo;
	}

	public void setLicenceNo(String licenceNo) {
		this.licenceNo = licenceNo;
	}

	@Override
	public String toString() {
		return "Outlet [outletId=" + outletId + ", name=" + name + ", address=" + address + ", contactNo=" + contactNo
				+ ", licenceNo=" + licenceNo + "]";
	}
	
	

	
}
