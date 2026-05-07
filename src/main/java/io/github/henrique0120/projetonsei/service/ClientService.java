package io.github.henrique0120.projetonsei.service;

import io.github.henrique0120.projetonsei.model.AGR;
import io.github.henrique0120.projetonsei.model.Client;
import io.github.henrique0120.projetonsei.repository.AGRRepository;
import io.github.henrique0120.projetonsei.repository.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ClientService {

    @Autowired
    private ClientRepository clientRepository;

    @Autowired
    private AGRRepository AGRrepository;

    public Client registerClient(Client client, int agrId){
        AGR agr = AGRrepository.getReferenceById(agrId);
        client.setAgr(agr);
        return clientRepository.save(client);
    }

    public void updateClient(int Id, int agrId, Client client) {
        AGR agr = AGRrepository.getReferenceById(agrId);
        client.setAgr(agr);
        client.setId(Id);
        clientRepository.save(client);
    }

    public void deleteClient(int Id){
        clientRepository.deleteById(Id);
    }



}
