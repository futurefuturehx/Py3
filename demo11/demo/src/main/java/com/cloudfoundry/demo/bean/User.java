package com.cloudfoundry.demo.bean;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import org.hibernate.annotations.GenericGenerator;

@Entity
public class User {
	@Id
	@Column(length = 40)
	@GeneratedValue(generator = "randomId")
	@GenericGenerator(name = "randomId", strategy = "com.cloudfoundry.demo.bean.RandomIdGenerator")
	private String id;
	private String username;
	private String password;

	

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

}
