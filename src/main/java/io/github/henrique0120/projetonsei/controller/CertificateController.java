package io.github.henrique0120.projetonsei.controller;

import io.github.henrique0120.projetonsei.model.Certificate;
import io.github.henrique0120.projetonsei.repository.ClientRepository;
import io.github.henrique0120.projetonsei.service.CertificateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/certificate")
public class CertificateController {

    @Autowired
    private CertificateService certificateService;

    @PostMapping
    public Certificate saveCertificate(@RequestBody Certificate certificate, @RequestParam int clientId){
        certificateService.saveCertificate(certificate, clientId);
        return certificate;
    }

    @DeleteMapping("/delete/{Id}")
    public void deleteCertificate(@PathVariable("Id") int Id){
        certificateService.deleteCertificate(Id);
    }

}
