package io.github.henrique0120.projetonsei.controller;

import io.github.henrique0120.projetonsei.dto.request.RequestCertificateDTO;
import io.github.henrique0120.projetonsei.mapper.CertificateMapper;
import io.github.henrique0120.projetonsei.model.Certificate;
import io.github.henrique0120.projetonsei.service.CertificateService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.apache.catalina.connector.Response;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.UUID;

@RestController
@RequestMapping("/certificate")
@RequiredArgsConstructor
public class CertificateController implements GenericController{

    private final CertificateService certificateService;
    private final CertificateMapper mapper;

    @GetMapping("{id}")
    public ResponseEntity<Object> searchCertificate(@PathVariable String id){
        return ResponseEntity.ok(certificateService.buscarPorId(id));
    }

    @PostMapping
    public ResponseEntity<Object> saveCertificate(@RequestBody @Valid RequestCertificateDTO dto){
        Certificate certificado = mapper.toEntity(dto);
        certificateService.saveCertificate(certificado);
        URI location = gerarHeaderLocation(certificado.getTicket());
        return ResponseEntity.created(location).body("Certificado emitido com sucesso!");
    }

    @DeleteMapping("{id}")
    public void deleteCertificate(@PathVariable("id") UUID id){
        certificateService.deleteCertificate(id);
    }

}
