package io.github.henrique0120.projetonsei.controller;

import io.github.henrique0120.projetonsei.model.Client;
import io.github.henrique0120.projetonsei.service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/client")
public class ClientController {

    private final ClientService service;

    public ClientController(ClientService service) {
        this.service = service;
    }

    @PostMapping
    public Client registerClient(@RequestBody Client client, @RequestParam UUID agrId){
        return service.registerClient(client, agrId);
    }

    @PutMapping("/update/{Id}")
    public void updateClient(@PathVariable UUID Id,
                             @RequestBody Client client,
                             @RequestParam UUID agrId) {
        service.updateClient(Id, agrId, client);
    }

    @DeleteMapping("/delete/{Id}")
    public void deleteClient(@PathVariable("Id") UUID Id){
        service.deleteClient(Id);
    }



}
