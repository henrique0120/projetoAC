package io.github.henrique0120.projetonsei.dto.request;

import jakarta.validation.constraints.NotBlank;

public record RequestAuthLoginDTO (
        @NotBlank
        String name,
        @NotBlank
        String password

){}
