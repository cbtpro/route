package com.route.www.domain.user;

import org.springframework.data.annotation.Id;

public class Customer {

	@Id
	public String id;

	public String userName;
	public String tel;

	public Customer() {}

	public Customer(String userName, String tel) {
		this.userName = userName;
		this.tel = tel;
	}

	@Override
	public String toString() {
		return String.format("Customer[id=%s, userName='%s', tel='%s']", id, userName, tel);
	}

}