package com.auth.authrizationserver.service;

import com.auth.authrizationserver.dto.CreateClientDto;
import com.auth.authrizationserver.dto.messageDto;
import com.auth.authrizationserver.entity.Client;
import com.auth.authrizationserver.repository.ClientRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.oauth2.server.authorization.client.RegisteredClient;
import org.springframework.security.oauth2.server.authorization.client.RegisteredClientRepository;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class clientService implements RegisteredClientRepository {
    private final ClientRepository clientRepository;
    private final PasswordEncoder passwordEncoder;

    @Override
    public void save(RegisteredClient registeredClient) {

    }
    @Override
    public RegisteredClient findById(String id) {
        Client client = clientRepository.findByclientId(id)
                .orElseThrow(()-> new RuntimeException("Client not found"));

        return Client.toRegisteredClient(client);
    }
    @Override
    public RegisteredClient findByClientId(String clientId) {
        Client client = clientRepository.findByclientId(clientId)
                .orElseThrow(()-> new RuntimeException("Client not found"));

        return Client.toRegisteredClient(client);
    }

    public messageDto create(CreateClientDto dto) {
        Client client = clientFromDto(dto);
        clientRepository.save(client);
        return new messageDto("client " + client.getClientId() + " saved ");
    }

//    private methods------------------------------------------------------

    private Client clientFromDto(CreateClientDto dto) {
        Client client = Client.builder()
                .clientId(dto.getClientId())
                .clientSecret(passwordEncoder.encode(dto.getClientSecret()))
                .authenticationMethods(dto.getAuthenticationMethods())
                .authorizationGrantTypes(dto.getAuthorizationGrantTypes())
                .redirectUris(dto.getRedirectUris())
                .scopes(dto.getScopes())
                .requireProofKey(dto.isRequireProofKey())
                .build();
        return client;
    }
}
