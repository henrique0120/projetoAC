package io.github.henrique0120.projetonsei.service;

import io.github.henrique0120.projetonsei.enums.CertificateStatus;
import io.github.henrique0120.projetonsei.model.Certificate;
import io.github.henrique0120.projetonsei.repository.CertificateRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Optional;
import java.util.UUID;


@Service
public class CertificateService {

    @Autowired
    private CertificateRepository certificateRepository;

    public Optional<Certificate> buscarPorId(String id) {
        UUID certificadoId = UUID.fromString(id);

        return certificateRepository.findById(certificadoId)
                .map(certificado -> {
                    if (certificado.getDataValidade().isBefore(LocalDateTime.now())) {
                        certificado.setStatus(CertificateStatus.VENCIDO);
                        certificateRepository.save(certificado);
                    }
                    return certificado;
                });
    }

    public void saveCertificate(Certificate certificate){
        LocalDateTime dataValidade = LocalDateTime.now();
        switch(certificate.getType()){
            case ECNPJ_A3, ECNPJ_A3_NUVEM,
                 ECPF_A3_NUVEM, ECPF_A3 -> certificate.setDataValidade(dataValidade.plusYears(3));
            case ECNPJ_A1, ECPF_A1, E_PJ,E_PF -> certificate.setDataValidade(dataValidade.plusYears(1));
        }
        certificate.setStatus(CertificateStatus.EMITIDO);
        certificateRepository.save(certificate);
    }

    public void deleteCertificate(UUID id){
        certificateRepository.deleteById(id);
    }
}
