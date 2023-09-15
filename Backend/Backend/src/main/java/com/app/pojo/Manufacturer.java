package com.app.pojo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Table;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name="Manufacturer")
public class Manufacturer {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="manufac_id")
	private Long manufacturerId;
	
	
	@Column(name="manufac_name")
	private String manufacturerName;
	
//	@Lob
//	@Column(name="image")
//	private byte[] model_img;
	
	public Manufacturer() {
		
	}

	public Manufacturer(String manufacturerName/*, byte[] model_img*/) {
		super();
		this.manufacturerName = manufacturerName;
//		this.model_img = model_img;
	}

	public Long getManufacturerId() {
		return manufacturerId;
	}

	public void setManufacturerId(Long manufacturerId) {
		this.manufacturerId = manufacturerId;
	}

	public String getManufacturerName() {
		return manufacturerName;
	}

	public void setManufacturerName(String manufacturerName) {
		this.manufacturerName = manufacturerName;
	}

//	public byte[] getModel_img() {
//		return model_img;
//	}
//
//	public void setModel_img(byte[] model_img) {
//		this.model_img = model_img;
//	}
	
	
}
