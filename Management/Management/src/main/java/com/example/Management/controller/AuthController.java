package com.example.Management.controller;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.Management.service.abstracts.AuthService;
import com.example.Management.service.requests.LoginDto;
import com.example.Management.service.requests.RequestDto;
import com.example.Management.service.responses.AuthResponseDto;

@RestController
@RequestMapping("/api/auth")
public class AuthController {

	@Autowired
	private AuthService authService;

	@PostMapping("login")
	public ResponseEntity<AuthResponseDto> login(@RequestBody LoginDto loginDto) {

		AuthResponseDto authResponseDto = authService.login(loginDto);

		return new ResponseEntity<>(authResponseDto, HttpStatus.OK);
	}

	@PostMapping("register")
	public String register(@RequestBody RequestDto requestDto) {

		String result = authService.register(requestDto);
		return result;

	}

}
