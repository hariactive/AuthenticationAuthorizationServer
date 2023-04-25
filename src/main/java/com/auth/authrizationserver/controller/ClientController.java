package com.auth.authrizationserver.controller;

import com.auth.authrizationserver.dto.CreateClientDto;
import com.auth.authrizationserver.dto.messageDto;
import com.auth.authrizationserver.service.clientService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/client")
@RequiredArgsConstructor
@Slf4j
public class ClientController {
    private final clientService clientservice;

    @PostMapping("/create")
    public ResponseEntity<messageDto> create(@RequestBody CreateClientDto dto) {
        return ResponseEntity.status(HttpStatus.CREATED).body(clientservice.create(dto));
    }
}
