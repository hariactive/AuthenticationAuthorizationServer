package com.auth.authrizationserver.repository;

import com.auth.authrizationserver.entity.Role;
import com.auth.authrizationserver.enums.RoleName;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface RoleRepository extends JpaRepository<Role,Integer> {


    Optional<Role> findByRole(RoleName roleName);
}
