package com.app.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.app.pojo.Payments;

public interface PaymentsDao extends JpaRepository<Payments, Long> {

	@Query(value="SELECT p.* FROM payments p JOIN appointment a ON p.appointment_id = a.appointment_id WHERE a.user_id = ?1", nativeQuery = true)
	public List<Payments> getPaymentByUserId(Long id);
	
	@Query("SELECT p FROM Payments p JOIN FETCH p.appointment a WHERE a.outlet.outletId = :outletId")
    public List<Payments> getPaymentsByOutletId(@Param("outletId") Long outletId);

}
