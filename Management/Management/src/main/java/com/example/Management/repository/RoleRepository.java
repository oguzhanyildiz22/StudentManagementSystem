package com.example.Management.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.Management.entity.Role;

public interface RoleRepository extends JpaRepository<Role, Integer> {
	
	Optional<Role> findByName(String name);
	
	boolean existsByName(String name);

}
