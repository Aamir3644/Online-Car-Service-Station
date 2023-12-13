package com.app.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.app.pojo.Cart;
import com.app.pojo.Services;
import com.app.service.CartService;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/cart")
public class CartController {

	@Autowired
	private CartService service;
	
	@PostMapping
	public void addToCart(@RequestBody Map<String, Long> request)
	{
		System.out.println();
		Long service_id = request.get("serviceId");
	    Long user_id = request.get("userId");
		service.addToCart(service_id, user_id);
	}
	
	@DeleteMapping
	public int deleteFromCart(@RequestBody Map<String, Long> request) 
	{
		Long serviceId = request.get("serviceId");
	    Long userId = request.get("userId");
		return service.deleteFromCart(serviceId, userId);
	}
	
	@GetMapping("/{userId}")
	public List<Services> getCartItemsById(@PathVariable Long userId)
	{
		return service.getCartItemsById(userId);
	}
	
	@DeleteMapping("/deleteItemsForUser/{userId}")
    public int deleteCartItemsForUser(@PathVariable Long userId) 
	{       
		System.out.println("in delete from cart bu user_id controller");
        return service.deleteCartItemsForUser(userId);
    }
	
}
