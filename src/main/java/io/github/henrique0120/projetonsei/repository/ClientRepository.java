package io.github.henrique0120.projetonsei.repository;

import io.github.henrique0120.projetonsei.model.AGR;
import io.github.henrique0120.projetonsei.model.Client;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ClientRepository extends JpaRepository<Client, Integer> {

    Optional<Client> findById(Integer Id);
    boolean existsBycpf(String cpf);
    boolean existsByemail(String email);
}
