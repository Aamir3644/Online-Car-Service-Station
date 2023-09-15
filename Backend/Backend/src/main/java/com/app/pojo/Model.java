package com.app.pojo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name="Model")
public class Model {
	

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="model_id")
	private Long modelId;
	
	@Column(name="model_name")
	private String modelName;
	
	@ManyToOne
	@JoinColumn(name="manufac_id")
	private Manufacturer manfacturer;
	
//	@Lob
//	@Column(name="logo")
//	private byte[] manufac_logo;
	
	public Model() {
		
	}

	public Model(String modelName, Manufacturer manfacturer/*, byte[] manufac_logo*/) {
		super();
		this.modelName = modelName;
		this.manfacturer = manfacturer;
//		this.manufac_logo = manufac_logo;
	}

	public Long getModelId() {
		return modelId;
	}

	public void setModelId(Long modelId) {
		this.modelId = modelId;
	}

	public String getModelName() {
		return modelName;
	}

	public void setModelName(String modelName) {
		this.modelName = modelName;
	}

	public Manufacturer getManfacturer() {
		return manfacturer;
	}

	public void setManfacturer(Manufacturer manfacturer) {
		this.manfacturer = manfacturer;
	}

//	public byte[] getManufac_logo() {
//		return manufac_logo;
//	}

//	public void setManufac_logo(byte[] manufac_logo) {
//		this.manufac_logo = manufac_logo;
//	}
	
	

}
