package io.github.henrique0120.projetonsei.dto.response;

import jakarta.persistence.Column;

import java.util.UUID;

public record ResponseClientDTO(
        UUID id,
        String clientId,
        String clientSecret,
        String redirectURI,
        String scope
) {}
