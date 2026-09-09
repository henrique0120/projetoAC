package io.github.henrique0120.projetonsei.controller;

import io.github.henrique0120.projetonsei.dto.request.RequestCertificateDTO;
import io.github.henrique0120.projetonsei.mapper.CertificateMapper;
import io.github.henrique0120.projetonsei.model.Certificate;
import io.github.henrique0120.projetonsei.service.CertificateService;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.Random;
import java.util.UUID;

@RestController
@RequestMapping("/certificate")
@RequiredArgsConstructor
@Tag(name = "Certificate")
public class CertificateController implements GenericController{

    private final CertificateService certificateService;
    private final CertificateMapper mapper;

    @GetMapping("{id}")
    @PreAuthorize("hasRole('AGR')")
    public ResponseEntity<Object> searchCertificate(@PathVariable String id){
        return ResponseEntity.ok(certificateService.buscarPorId(id));
    }

    @PostMapping
    @PreAuthorize("hasRole('AGR')")
    public ResponseEntity<Object> saveCertificate(@RequestBody @Valid RequestCertificateDTO dto){
        Certificate certificado = mapper.toEntity(dto);
        Random random = new Random();
        var a = random.nextLong(999999999);
        certificado.setTicket(a);
        certificateService.saveCertificate(certificado);
        URI location = gerarHeaderLocation(certificado.getId());
        return ResponseEntity.created(location).body("Certificado emitido com sucesso!");
    }

    @DeleteMapping("{id}")
    @PreAuthorize("hasRole('AGR')")
    public void deleteCertificate(@PathVariable("id") UUID id){
        certificateService.deleteCertificate(id);
    }

}
