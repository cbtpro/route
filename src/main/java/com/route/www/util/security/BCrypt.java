package com.route.www.util.security;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

public class BCrypt {
	
	public final static PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
	public static String salt = "#……%DTR%E%^&EFY";
	
	public static String encrypt(String password) {
		return passwordEncoder.encode(password);
	}
	public static boolean dencrypt(String rawPassword, String encodedPassword) {
		return passwordEncoder.matches(rawPassword,encodedPassword);
	}
	public static void main(String[] args) {
		String password = BCrypt.encrypt(salt);
		System.out.println(password);
		boolean is = BCrypt.dencrypt(salt, "$2a$10$G547.2HOvOee5I9Nw9YUNO5I1KgMFsBdFVZqClySMpDJJqFJg49m2");
		System.out.println(is);
	}
}
