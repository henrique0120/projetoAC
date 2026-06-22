package io.github.henrique0120.projetonsei.dto.response;

import io.github.henrique0120.projetonsei.enums.CertificateType;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.util.UUID;

public record ResponseCertificateDTO(
        @NotNull
        int token,
        @NotBlank
        String password,
        @NotNull
        CertificateType type,
        @NotNull
        UUID idClient
) {
}
