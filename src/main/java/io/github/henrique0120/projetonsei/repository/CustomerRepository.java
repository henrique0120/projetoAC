package io.github.henrique0120.projetonsei.repository;

import io.github.henrique0120.projetonsei.model.AGR;
import io.github.henrique0120.projetonsei.model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, UUID> {

    Optional<Customer> findById(UUID id);
    boolean existsBycpf(String cpf);
    boolean existsByemail(String email);

    //JPQL
    @Query("select a from Customer c join c.agr a")
    List<AGR> listarAGRsDosCustomers();

    @Query("select n from Customer as n order by n.name")
    List<Customer> listarNomesDosCustomers();


}
