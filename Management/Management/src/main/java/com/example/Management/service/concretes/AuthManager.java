package com.example.Management.service.concretes;

import java.util.Collections;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.example.Management.entity.Role;
import com.example.Management.entity.UserEntity;
import com.example.Management.repository.RoleRepository;
import com.example.Management.repository.UserRepository;
import com.example.Management.security.JwtGenerator;
import com.example.Management.service.abstracts.AuthService;
import com.example.Management.service.requests.LoginDto;
import com.example.Management.service.requests.RequestDto;
import com.example.Management.service.responses.AuthResponseDto;

@Service
public class AuthManager implements AuthService {

	@Autowired
	private AuthenticationManager authenticationManager;
	@Autowired
	private UserRepository userRepository;
	@Autowired
	private RoleRepository roleRepository;
	@Autowired
	private PasswordEncoder passwordEncoder;
	@Autowired
	private JwtGenerator jwtGenerator;

	@Override
	public AuthResponseDto login(LoginDto loginDto) {

		Authentication authentication = authenticationManager
				.authenticate(new UsernamePasswordAuthenticationToken(loginDto.getUsername(), loginDto.getPassword()));

		SecurityContextHolder.getContext().setAuthentication(authentication);
		String token = jwtGenerator.generateToken(authentication);

		AuthResponseDto authResponseDto = new AuthResponseDto();
		authResponseDto.setAccessToken(token);

		return authResponseDto;
	}

	@Override
	public String register(RequestDto requestDto) {

		if (userRepository.existsByUsername(requestDto.getUsername())) {
			return "Username is taken!";
		}
		UserEntity user = new UserEntity();
		user.setUsername(requestDto.getUsername());
		user.setPassword(passwordEncoder.encode(requestDto.getPassword()));

		if (!roleRepository.existsByName(requestDto.getRole())) {
			return "Wrong role_name. You can only use these words:'STUDENT','TEACHER','MODERATOR'";
		}
		Role roles = roleRepository.findByName(requestDto.getRole()).get();
		user.setRoles(Collections.singletonList(roles));

		userRepository.save(user);

		return "register successful";

	}

}
