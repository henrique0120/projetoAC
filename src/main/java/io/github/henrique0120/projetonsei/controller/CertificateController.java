package io.github.henrique0120.projetonsei.controller;

import io.github.henrique0120.projetonsei.model.Certificate;
import io.github.henrique0120.projetonsei.service.CertificateService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/certificate")
@RequiredArgsConstructor
public class CertificateController {

    private final CertificateService certificateService;

    @PostMapping
    public Certificate saveCertificate(@RequestBody Certificate certificate, @RequestParam UUID clientId){
        certificateService.saveCertificate(certificate, clientId);
        return certificate;
    }

    @DeleteMapping("/delete/{id}")
    public void deleteCertificate(@PathVariable("id") UUID id){
        certificateService.deleteCertificate(id);
    }

}
