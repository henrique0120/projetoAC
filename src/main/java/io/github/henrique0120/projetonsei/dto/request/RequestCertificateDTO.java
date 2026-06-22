package io.github.henrique0120.projetonsei.dto.request;

import io.github.henrique0120.projetonsei.enums.CertificateType;

import java.util.UUID;

public record RequestCertificateDTO(
        String password,
        CertificateType type,
        UUID idClient

) {
}
