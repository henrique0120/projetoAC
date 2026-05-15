package io.github.henrique0120.projetonsei.service;

import io.github.henrique0120.projetonsei.model.AGR;
import io.github.henrique0120.projetonsei.model.Certificate;
import io.github.henrique0120.projetonsei.model.Client;
import io.github.henrique0120.projetonsei.repository.CertificateRepository;
import io.github.henrique0120.projetonsei.repository.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;


@Service
public class CertificateService {

    @Autowired
    private CertificateRepository certificateRepository;

    @Autowired
    private ClientRepository clientRepository;

    public Certificate saveCertificate(Certificate certificate, UUID clientId){
        Client client = clientRepository.getReferenceById(clientId);
        certificate.setClient(client);
        return certificateRepository.save(certificate);
    }

    public void deleteCertificate(UUID Id){
        certificateRepository.deleteById(Id);
    }
}
