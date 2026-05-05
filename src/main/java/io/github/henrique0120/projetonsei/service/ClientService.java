package io.github.henrique0120.projetonsei.service;

import io.github.henrique0120.projetonsei.model.AGR;
import io.github.henrique0120.projetonsei.model.Client;
import io.github.henrique0120.projetonsei.repository.AGRRepository;
import io.github.henrique0120.projetonsei.repository.ClientRepository;
import jakarta.persistence.Id;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

@Service
public class ClientService {

    @Autowired
    private ClientRepository clientRepository;

    @Autowired
    private AGRRepository AGRrepository;

    public Client registerClient(@RequestBody Client client, @RequestParam int agrId){
        AGR agr = AGRrepository.getReferenceById(agrId);

        client.setAgr(agr); // 🔥 ESSA LINHA FALTAVA

        return clientRepository.save(client);
    }

}
