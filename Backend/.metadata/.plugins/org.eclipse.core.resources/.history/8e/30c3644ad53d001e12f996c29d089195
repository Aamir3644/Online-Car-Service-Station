package com.app.pojo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name="Manufacturer")
public class Manufacturer {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="manufac_id")
	private Long manufacturerId;
	
	
	@Column(name="manufac_name")
	private String manufacturerName;
	
	
	
}
