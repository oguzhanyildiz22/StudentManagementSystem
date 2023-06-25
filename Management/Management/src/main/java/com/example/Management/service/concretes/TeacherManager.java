package com.example.Management.service.concretes;

import com.example.Management.repository.UserRepository;
import com.example.Management.service.abstracts.TeacherService;

public class TeacherManager implements TeacherService{
	
	private UserRepository userRepository;

	@Override
	public void delete(int id) {
		
		userRepository.deleteById(id);
		
	}

}
