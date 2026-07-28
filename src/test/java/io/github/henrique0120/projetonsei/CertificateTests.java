package io.github.henrique0120.projetonsei;

import io.github.henrique0120.projetonsei.enums.CertificateStatus;
import io.github.henrique0120.projetonsei.enums.CertificateType;
import io.github.henrique0120.projetonsei.model.Certificate;
import io.github.henrique0120.projetonsei.model.Customer;
import io.github.henrique0120.projetonsei.repository.CertificateRepository;
import io.github.henrique0120.projetonsei.repository.CustomerRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDateTime;
import java.util.UUID;

@SpringBootTest
public class CertificateTests {

    @Autowired
    CertificateRepository repository;

    @Autowired
    CustomerRepository customerRepository;

    @Test
    void testeValidade(){
        Certificate certificate = new Certificate();
        certificate.setPassword("123456789");
        certificate.setDataEmissao(LocalDateTime.now().minusDays(1));
        certificate.setDataValidade(LocalDateTime.now());
        certificate.setType(CertificateType.ECNPJ_A1);
        certificate.setStatus(CertificateStatus.EMITIDO);

        Customer customer = customerRepository
                .findById(UUID.fromString("e39db68a-2358-4502-88ef-7c9baf2b3a36"))
                .orElse(null);

        certificate.setCustomer(customer);
        repository.save(certificate);
    }
}
