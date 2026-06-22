package io.github.henrique0120.projetonsei.service;

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

    public void saveCertificate(Certificate certificate){
        certificateRepository.save(certificate);
    }

    public void deleteCertificate(UUID id){
        certificateRepository.deleteById(id);
    }
}
