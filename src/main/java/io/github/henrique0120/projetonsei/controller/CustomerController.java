package io.github.henrique0120.projetonsei.controller;

import io.github.henrique0120.projetonsei.dto.request.RequestCustomerDTO;
import io.github.henrique0120.projetonsei.mapper.CustomerMapper;
import io.github.henrique0120.projetonsei.model.Customer;
import io.github.henrique0120.projetonsei.service.CustomerService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.UUID;

@RestController
@RequestMapping("/client")
@RequiredArgsConstructor
public class CustomerController implements GenericController{

    private final CustomerService service;
    private final CustomerMapper mapper;

    @PostMapping
    @PreAuthorize("hasRole('AGR')")
    public ResponseEntity<Object> registerCustomer(@RequestBody @Valid RequestCustomerDTO dto){
        Customer cliente = mapper.toEntity(dto);
        service.registerCustomer(cliente);
        URI location = gerarHeaderLocation(cliente.getId());
        return ResponseEntity.created(location).body("Registro de cliente feito com sucesso!");
    }

    @PutMapping("{id}")
    @PreAuthorize("hasRole('AGR')")
    public void updateCustomer(@PathVariable UUID id,
                             @RequestBody Customer customer,
                             @RequestParam UUID agrId) {
        service.updateCustomer(id, agrId, customer);
    }

    @DeleteMapping("{id}")
    @PreAuthorize("hasRole('AGR')")
    public void deleteCustomer(@PathVariable("id") UUID id){
        service.deleteCustomer(id);
    }
}
