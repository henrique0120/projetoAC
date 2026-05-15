package io.github.henrique0120.projetonsei;

import io.github.henrique0120.projetonsei.model.AGR;
import io.github.henrique0120.projetonsei.repository.AGRRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.UUID;

@SpringBootTest
public class AGRRepositoryTests {

    @Autowired
    AGRRepository repository;

    @Test
    public void salvarTest(){
        AGR agr = new AGR();
        agr.setCpf("12345678910");
        agr.setName("henrique");
        agr.setEmail("henrique@email.com");

        var attAgr = repository.save(agr);
        System.out.println(attAgr);

    }

//    @Test
//    public void atualizarTest(){
//        var id = UUID.fromString("1");
//    }

}
