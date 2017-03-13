package com.route.www.util.security;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class BCrypt {

	public static String encrypt(String password) {
		BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
		return passwordEncoder.encode("password");
	}
	public static void main(String[] args) {
		String password = BCrypt.encrypt("123456");
		System.out.println(password);
	}
}
