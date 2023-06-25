package com.example.Management.service.concretes;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import com.example.Management.entity.Role;
import com.example.Management.repository.RoleRepository;

@Component
public class RoleInitializer implements ApplicationRunner {

    private final RoleRepository roleRepository;

    @Autowired
    public RoleInitializer(RoleRepository roleRepository) {
        this.roleRepository = roleRepository;
    }

    @Override
    public void run(ApplicationArguments args) {
        if (roleRepository.count() == 0) {
            initializeRoles();
        }
    }

    private void initializeRoles() {
        Role adminRole = new Role();
        adminRole.setName("STUDENT");
        roleRepository.save(adminRole);

        Role operatorRole = new Role();
        operatorRole.setName("TEACHER");
        roleRepository.save(operatorRole);

        Role teamLeaderRole = new Role();
        teamLeaderRole.setName("MODERATOR");
        roleRepository.save(teamLeaderRole);
    }
}
