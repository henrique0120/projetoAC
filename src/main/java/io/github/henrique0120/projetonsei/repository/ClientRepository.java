package io.github.henrique0120.projetonsei.repository;

import io.github.henrique0120.projetonsei.model.AGR;
import io.github.henrique0120.projetonsei.model.Client;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository
public interface ClientRepository extends JpaRepository<Client, UUID> {

    Optional<Client> findById(UUID id);
    boolean existsBycpf(String cpf);
    boolean existsByemail(String email);

    //JPQL
    @Query("select a from Client c join c.agr a")
    List<AGR> listarAGRsDosClients();

    @Query("select n from Client as n order by n.name")
    List<Client> listarNomesDosClients();


}
