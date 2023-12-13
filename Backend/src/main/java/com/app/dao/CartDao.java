package com.app.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import com.app.pojo.Cart;
import com.app.pojo.Services;

public interface CartDao extends JpaRepository<Cart, Long>{
	
	@Modifying
	@Query(value="delete from cart where service_id=?1 and user_id=?2",nativeQuery = true)
	public int deleteFromCart(Long serviceId, Long userId);
	
//	int deleteByServiceIdAndUserId(Long serviceId, Long userId);
	
//	@Query(value="SELECT s.* FROM services AS s JOIN cart AS c ON s.service_id = c.service_id WHERE c.user_id =?1",nativeQuery = true)
//	public List<Services> getCartItemsById(Long userId);
	
	@Modifying
	@Query(value="insert into cart(service_id,user_id) values(?1,?2)", nativeQuery = true)
	public void addToCart(Long service_id,Long user_id);
	
	@Modifying
	@Query(value="DELETE FROM Cart c WHERE c.user.id = ?1")
	public int deleteCartItemsForUser(Long userId);
}


