package com.auth.authrizationserver;

import com.auth.authrizationserver.entity.Role;
import com.auth.authrizationserver.enums.RoleName;
import com.auth.authrizationserver.repository.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class AuthrizationServerApplication /*implements CommandLineRunner*/ {
//	@Autowired
//	RoleRepository repository;

	public static void main(String[] args) {
		SpringApplication.run(AuthrizationServerApplication.class, args);
	}

//	@Override
//	public void run(String... args) throws Exception {
//		Role adminRole = Role.builder().role(RoleName.ROLE_ADMIN).build();
//		Role userRole = Role.builder().role(RoleName.ROLE_USER).build();
//		repository.save(adminRole);
//		repository.save(userRole);
//	}

}

