package io.github.henrique0120.projetonsei.dto.request;

import jakarta.validation.constraints.NotBlank;

public record RequestEmitionDTO (

        @NotBlank
        long ticket,
        @NotBlank
        String password

){}
