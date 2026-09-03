package io.github.henrique0120.projetonsei.dto.request;

import io.github.henrique0120.projetonsei.enums.RoleType;
import io.github.henrique0120.projetonsei.model.Roles;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
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
    @NotNull
    private RoleType role;

}
