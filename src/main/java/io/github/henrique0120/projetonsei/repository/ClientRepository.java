package io.github.henrique0120.projetonsei.repository;

import io.github.henrique0120.projetonsei.model.Client;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface ClientRepository extends JpaRepository<Client, UUID> {

    Client findByClientId(String clientId);

}
