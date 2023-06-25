package com.example.Management.service.concretes;

import java.util.List;

import com.example.Management.entity.UserEntity;
import com.example.Management.repository.UserRepository;
import com.example.Management.service.abstracts.TeacherService;

public class TeacherManager implements TeacherService{
	
	private UserRepository userRepository;

	@Override
	public void delete(int id) {
		
		userRepository.deleteById(id);
		
	}

	@Override
	public List<UserEntity> listUsers() {
		return userRepository.findAll();
	}

}
