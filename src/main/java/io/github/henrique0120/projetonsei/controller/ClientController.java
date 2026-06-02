package io.github.henrique0120.projetonsei.controller;

import io.github.henrique0120.projetonsei.model.Client;
import io.github.henrique0120.projetonsei.service.ClientService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/client")
@RequiredArgsConstructor
public class ClientController {

    private final ClientService service;

    @PostMapping
    public Client registerClient(@RequestBody Client client, @RequestParam UUID agrId){
        return service.registerClient(client, agrId);
    }

    @PutMapping("/update/{id}")
    public void updateClient(@PathVariable UUID id,
                             @RequestBody Client client,
                             @RequestParam UUID agrId) {
        service.updateClient(id, agrId, client);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteClient(@PathVariable("id") UUID id){
        service.deleteClient(id);
    }
}
