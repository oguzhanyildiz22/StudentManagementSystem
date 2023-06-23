package com.example.Management.service.requests;

import lombok.Data;

@Data
public class RequestDto {

	private String firstName;
	private String lastName;
	private String username;
	private String password;
	private String role;
}
