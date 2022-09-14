package com.sk.blog.springbootblogrestapi.utils;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

public class PasswordEncoderGenerator {

	public static void main(String[] args) {
		PasswordEncoder pe = new BCryptPasswordEncoder();
		System.out.println(pe.encode("sk486"));
	}
}
