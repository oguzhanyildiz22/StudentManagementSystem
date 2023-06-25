package com.example.Management.service.abstracts;

import java.util.List;

import com.example.Management.entity.UserEntity;

public interface TeacherService {

	void delete(int id);
	
	List<UserEntity> listUsers();
}
