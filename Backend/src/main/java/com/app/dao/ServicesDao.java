package com.app.dao;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.app.pojo.*;

public interface ServicesDao extends JpaRepository<Services,Long>{
	@Query(value="SELECT s.* FROM services AS s JOIN cart AS c ON s.service_id = c.service_id WHERE c.user_id =?1",nativeQuery = true)
	public List<Services> getCartItemsById(Long userId);
}
