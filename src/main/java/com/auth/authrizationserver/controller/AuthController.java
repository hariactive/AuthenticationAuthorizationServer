package com.auth.authrizationserver.controller;

import com.auth.authrizationserver.dto.CreateAppUserDto;
import com.auth.authrizationserver.dto.messageDto;
import com.auth.authrizationserver.service.AppUserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/auth")
public class AuthController {

    private final AppUserService appUserService;

    @PostMapping("/create")
    public ResponseEntity<messageDto> createUser(@RequestBody CreateAppUserDto dto) {
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(appUserService.createUser(dto));
    }
}
