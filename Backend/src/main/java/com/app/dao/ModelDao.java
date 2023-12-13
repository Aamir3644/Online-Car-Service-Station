package com.app.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.app.pojo.Model;

public interface ModelDao extends JpaRepository<Model, Long>{

//	@Query(value="select model_name from model,manufacturer where model.manufac_id=manufacturer.manufac_id and manufacturer.manufac_id=:manufacId", nativeQuery = true)
//	@Query(value="SELECT m.model_name FROM model m JOIN manufacturer ma ON m.manufac_id = ma.manufac_id WHERE ma.manufac_name=?1", nativeQuery = true)
	@Query(value="SELECT * FROM model m WHERE m.manufac_id = ?1", nativeQuery=true)
	public List<Model> getModelByManufacId( Long id);
}
