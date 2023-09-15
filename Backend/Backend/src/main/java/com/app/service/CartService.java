package com.app.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.app.dao.CartDao;
import com.app.dao.ServicesDao;
import com.app.pojo.Cart;
import com.app.pojo.Services;

@Service
@Transactional
public class CartService {

	@Autowired
	private CartDao dao;
	
	@Autowired
	private ServicesDao serviceDao;
	
	public void addToCart(Long service_id,Long user_id) {
		dao.addToCart(service_id, user_id);
	}
	
	public int deleteFromCart(Long serviceId, Long userId) {
		return dao.deleteFromCart(serviceId, userId);
	}
	
	public List<Services> getCartItemsById(Long userId)
	{
		return serviceDao.getCartItemsById(userId);
	}
	
}