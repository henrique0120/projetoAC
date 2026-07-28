package io.github.henrique0120.projetonsei.dto.request;

import java.util.UUID;

public record RequestClientDTO(
        String clientId,
        String clientSecret,
        String redirectURI,
        String scope
) {}
