package io.github.henrique0120.projetonsei.service;

import io.github.henrique0120.projetonsei.components.ClientValidator;
import io.github.henrique0120.projetonsei.model.AGR;
import io.github.henrique0120.projetonsei.model.Client;
import io.github.henrique0120.projetonsei.repository.AGRRepository;
import io.github.henrique0120.projetonsei.repository.ClientRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class ClientService {

    private final ClientRepository clientRepository;
    private final AGRRepository AGRrepository;
    private final ClientValidator validator;

    public void registerClient(Client client){
        validator.validateClient(client);
        validator.validateEmail(client);
        clientRepository.save(client);
    }

    public void updateClient(UUID id, UUID agrId, Client client) {
        AGR agr = AGRrepository.getReferenceById(agrId);
        client.setAgr(agr);
        client.setId(id);
        clientRepository.save(client);
    }

    public void deleteClient(UUID id){
        clientRepository.deleteById(id);
    }
}
