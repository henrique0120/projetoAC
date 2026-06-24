package io.github.henrique0120.projetonsei.dto.request;

import io.github.henrique0120.projetonsei.enums.CertificateType;

import java.util.Date;
import java.util.UUID;

public record RequestCertificateDTO(
        Date dataEmissao,
        String password,
        CertificateType type,
        UUID idClient

) {
}
