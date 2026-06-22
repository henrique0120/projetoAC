package io.github.henrique0120.projetonsei.controller;

import io.github.henrique0120.projetonsei.dto.request.RequestCertificateDTO;
import io.github.henrique0120.projetonsei.mapper.CertificateMapper;
import io.github.henrique0120.projetonsei.model.Certificate;
import io.github.henrique0120.projetonsei.service.CertificateService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/certificate")
@RequiredArgsConstructor
public class CertificateController {

    private final CertificateService certificateService;
    private final CertificateMapper mapper;

    @PostMapping
    public ResponseEntity<Void> saveCertificate(@RequestBody @Valid RequestCertificateDTO dto){
        Certificate certificado = mapper.toEntity(dto);
        certificateService.saveCertificate(certificado);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("{id}")
    public void deleteCertificate(@PathVariable("id") UUID id){
        certificateService.deleteCertificate(id);
    }

}
