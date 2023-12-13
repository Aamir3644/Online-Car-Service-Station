package com.app.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.app.pojo.Appointment;
import com.app.service.AppointmentService;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/appointment")
public class AppointmentController {
	
	@Autowired
	private AppointmentService service;
	
	@GetMapping("/{uid}")
	public List<Appointment> appointmentById(@PathVariable Long uid){
		return service.getAppointmentById(uid);
	}
	
	@PostMapping
    public ResponseEntity<?> bookAppointment(@RequestBody Appointment appointment) {
        
        Appointment savedAppointment = service.bookAppointment(appointment);
        return ResponseEntity.ok(savedAppointment);
    }
	
	@GetMapping("/outlet/{oid}")
	public List<Appointment> appointmentByOutletId(@PathVariable Long oid){
		return service.getAppointmentByOutletId(oid);
	}
	
	@PutMapping("/update-status/{appointmentId}")
    public ResponseEntity<String> updateAppointmentStatus(
            @PathVariable Long appointmentId,
            @RequestBody Map<String, Boolean> statusMap) {
        boolean newStatus = statusMap.get("status");
        try {
            service.updateAppointmentStatus(appointmentId, newStatus);
            return ResponseEntity.ok("Status updated successfully");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Failed to update status: " + e.getMessage());
        }
    } 
}
