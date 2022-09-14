package com.sk.blog.springbootblogrestapi.payload;

import lombok.Data;

@Data
public class LoginDto {
	private String userNameOrEmail;
	private String password;
}
