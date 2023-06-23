package com.example.Management.service.abstracts;

import com.example.Management.service.requests.LoginDto;
import com.example.Management.service.requests.RequestDto;
import com.example.Management.service.responses.AuthResponseDto;

public interface AuthService {

	/**
	 * Bearer token is returned to the user by asking the registered 
	 * user to enter a username and password.
	 * 
	 * @param  loginDto :<br>  String username <br> String password
	 * @return  String bearer token 
	 */
	AuthResponseDto login(LoginDto loginDto);
	
	/**
	 * user registers with username, password and role
	 * 
	 * @param  requestDto : <br> String username <br> String password <br> String role
	 * @return String message 
	 */
	String register(RequestDto requestDto);
	
	
	
}
