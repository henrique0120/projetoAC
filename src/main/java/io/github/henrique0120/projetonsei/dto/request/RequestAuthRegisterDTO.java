package io.github.henrique0120.projetonsei.dto.request;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Builder
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class RequestAuthRegisterDTO{

    @NotBlank
    private String name;
    @NotBlank
    private String password;
    @NotBlank
    private String email;

}
