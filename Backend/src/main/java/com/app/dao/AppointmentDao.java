package com.app.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.app.pojo.Appointment;

public interface AppointmentDao extends JpaRepository<Appointment, Long> {
	
//	@Query(value = "select * from appointment  where user_id = ?1", nativeQuery = true)
	@Query("SELECT a FROM Appointment a JOIN FETCH a.user u WHERE u.userId = ?1")
	public List<Appointment> getAppointmentById(Long id);
	
	@Query("SELECT a FROM Appointment a WHERE a.outlet.outletId = ?1")
	public List<Appointment> getAppointmentByOutletId(Long id);
	
}
