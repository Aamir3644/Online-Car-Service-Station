package com.app.pojo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="Cart")
public class Cart{
	

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="cart_id")
	private Long cartId;
	
	@ManyToOne
	@JoinColumn(name = "user_id")
	private Users user;

	@ManyToOne
	@JoinColumn(name = "service_id")
	private Services service;

	public Cart() {
		
	}

	public Users getUser() {
		return user;
	}

	public void setUser(Users user) {
		this.user = user;
	}

	public Services getService() {
		return service;
	}

	public void setService(Services service) {
		this.service = service;
	}
	
	@Override
	public String toString() {
		return "Cart [cartId=" + cartId + ", user=" + user + ", service=" + service + "]";
	}
	
}
