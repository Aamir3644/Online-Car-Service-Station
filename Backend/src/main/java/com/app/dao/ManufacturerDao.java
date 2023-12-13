package com.app.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.app.pojo.Manufacturer;

public interface ManufacturerDao extends JpaRepository<Manufacturer, Long>{

}
