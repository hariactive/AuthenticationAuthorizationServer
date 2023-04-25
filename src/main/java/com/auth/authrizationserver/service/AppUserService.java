package com.auth.authrizationserver.service;

import com.auth.authrizationserver.dto.CreateAppUserDto;
import com.auth.authrizationserver.dto.messageDto;
import com.auth.authrizationserver.entity.AppUser;
import com.auth.authrizationserver.entity.Role;
import com.auth.authrizationserver.enums.RoleName;
import com.auth.authrizationserver.repository.AppUserRepository;
import com.auth.authrizationserver.repository.RoleRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
@RequiredArgsConstructor
@Slf4j
public class AppUserService {
    private final AppUserRepository appUserRepository;
    private final RoleRepository roleRepository;
    private final PasswordEncoder passwordEncoder;

    public messageDto createUser(CreateAppUserDto dto){
        AppUser appUser = AppUser.builder()
                .username(dto.username())
                .password(passwordEncoder.encode(dto.password()))
                .build();
        Set<Role> roles = new HashSet<>();
        dto.roles().forEach(r ->{
            Role role = roleRepository.findByRole(RoleName.valueOf(r))
                    .orElseThrow(()-> new RuntimeException("role not found"));
            roles .add(role);
        });
        appUser.setRoles(roles);
        appUserRepository.save(appUser);
        return new messageDto("user " + appUser.getUsername() + " Saved.");
    }
}
