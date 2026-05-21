package io.github.henrique0120.projetonsei;

import io.github.henrique0120.projetonsei.model.AGR;
import io.github.henrique0120.projetonsei.repository.AGRRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@SpringBootTest
public class AGRRepositoryTests {

    @Autowired
    AGRRepository repository;

    @Test
    void registerTest(){
        AGR agr = new AGR();
        agr.setCpf("09847564839");
        agr.setName("Marcos");
        agr.setEmail("Marcos@email.com");

        var attAgr = repository.save(agr);
        System.out.println(attAgr);

    }

    @Test
    void updateTest(){
        var id = UUID.fromString("ec57c4e2-1897-4a1c-91a9-5e2f66225de7");

        Optional<AGR> possibleAGR = repository.findById(id);

        if (possibleAGR.isPresent()){
            AGR autorEncontrado = possibleAGR.get();
            autorEncontrado.setName("Joao");
            repository.save(autorEncontrado);
        }
    }

    @Test
    void getAGR(){
        List<AGR> listagrs = repository.findAll();
        for (AGR listagr : listagrs) {
            System.out.println(listagr);
        }
    }


}
