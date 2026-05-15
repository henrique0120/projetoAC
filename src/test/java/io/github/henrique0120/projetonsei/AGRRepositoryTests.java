package io.github.henrique0120.projetonsei;

import io.github.henrique0120.projetonsei.model.AGR;
import io.github.henrique0120.projetonsei.repository.AGRRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@SpringBootTest
public class AGRRepositoryTests {

    @Autowired
    AGRRepository repository;

    @Test
    public void registerTest(){
        AGR agr = new AGR();
        agr.setCpf("92748578320");
        agr.setName("joao");
        agr.setEmail("joao@email.com");

        var attAgr = repository.save(agr);
        System.out.println(attAgr);

    }

    @Test
    public void updateTest(){
        var id = UUID.fromString("6f50c74d-8f5f-4ef9-9c2d-7e6da0e0b0a8");

        Optional<AGR> possibleAGR = repository.findById(id);
        AGR agr = new AGR();

        if (possibleAGR.isPresent()){
            AGR autorEncontrado = possibleAGR.get();
            autorEncontrado.setName("henrique de souza silva");
            repository.save(autorEncontrado);
        }
    }

    @Test
    public void getAGR(){
        List<AGR> listagrs = repository.findAll();
        for (AGR listagr : listagrs) {
            System.out.println(listagr);
        }

    }

}
