package io.github.henrique0120.projetonsei.repository;

import io.github.henrique0120.projetonsei.model.AGR;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface AGRRepository extends JpaRepository<AGR, UUID> {

    Optional<AGR> findById(UUID id);
    boolean existsBycpf(String cpf);
    boolean existsByemail(String email);

}
