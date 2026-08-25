package io.github.henrique0120.projetonsei.dto.request;

import jakarta.validation.constraints.NotBlank;
import lombok.*;

@Builder
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class RequestAuthLoginDTO {

        @NotBlank
        String email;
        @NotBlank
        String password;
}
