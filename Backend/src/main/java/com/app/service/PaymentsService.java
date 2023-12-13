package com.app.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.app.dao.PaymentsDao;
import com.app.pojo.Payments;

@Service
@Transactional
public class PaymentsService {
	
	@Autowired
	private PaymentsDao dao;
	
	public List<Payments> getPaymentById(Long id){
		return dao.getPaymentByUserId(id); 
	}
	
	public Payments addPaymentDetails(Payments payment) {
		return dao.save(payment);
		}
	
	public List<Payments> getPaymentsByOutletId(Long outletId) {
        return dao.getPaymentsByOutletId(outletId);
    }
}
