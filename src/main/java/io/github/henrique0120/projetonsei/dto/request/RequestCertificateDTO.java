package io.github.henrique0120.projetonsei.dto.request;

import io.github.henrique0120.projetonsei.enums.CertificateType;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.util.UUID;

public record RequestCertificateDTO(
        @NotBlank(message = "O campo senha não pode ficar vazio")
        String password,
        @NotNull(message = "É necessário colocar o título do certificado")
        CertificateType type,
        @NotNull(message = "Coloque o ID do cliente")
        UUID idClient

) {
}
