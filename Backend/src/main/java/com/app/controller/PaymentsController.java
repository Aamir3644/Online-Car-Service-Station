package com.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.pojo.Payments;
import com.app.service.PaymentsService;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/payments")
public class PaymentsController {
	
	@Autowired
	private PaymentsService service;
	
	@GetMapping("/{id}")
	private List<Payments> paymentById(@PathVariable Long id) {
		return service.getPaymentById(id);
	}
	
	@PostMapping
	public Payments addPayment(@RequestBody Payments payment)
	{
		System.out.println(payment);
	return service.addPaymentDetails(payment);
	}
	
	@GetMapping("/outlet/{outletId}")
    public ResponseEntity<List<Payments>> getPaymentsByOutletId(@PathVariable Long outletId) {
        List<Payments> payments = service.getPaymentsByOutletId(outletId);
        return new ResponseEntity<>(payments, HttpStatus.OK);
    }
}
