package com.app.pojo;

import java.io.Serializable;
import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name="Users",uniqueConstraints= @UniqueConstraint(columnNames ="email" ))
public class Users  {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long userId;
	
	@Column(name="fname",length=20)
	private String fname;
	
	@Column(name="lname",length=20)
	private String lname;
	
	@Column(name="role",length=20)
	private String role;
	
	@Column(name="email",length=20)
    private String email;
	
	private String password;
	
	@ManyToOne
	@JoinColumn(name="outlet_id")
	private Outlet outlet;
	
	private int enabled=1;

	public Users(Long userId, String fname, String lname, String role, String email, String password, Outlet outlet) {
		super();
		this.userId = userId;
		this.fname = fname;
		this.lname = lname;
		this.role = role;
		this.email = email;
		this.password = password;
		this.outlet = outlet;
	}
	
    public int getEnabled() {
		return enabled;
	}


	public void setEnabled(int enabled) {
		this.enabled = enabled;
	}

	public Users() {
		
	}
	
	public Users(Long userId) {
		super();
		this.userId = userId;
	}

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public String getFname() {
		return fname;
	}

	public void setFname(String fname) {
		this.fname = fname;
	}

	public String getLname() {
		return lname;
	}

	public void setLname(String lname) {
		this.lname = lname;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Outlet getOutlet() {
		return outlet;
	}

	public void setOutlet(Outlet outlet) {
		this.outlet = outlet;
	}


	@Override
	public String toString() {
		return "Users [userId=" + userId + ", fname=" + fname + ", lname=" + lname + ", role=" + role + ", email="
				+ email + ", outlet=" + outlet + "]";
	}
	
	
	
}
