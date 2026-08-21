package io.github.henrique0120.projetonsei.dto.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Builder
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class RequestAuthRegisterDTO{

    private String name;
    private String password;
    private String email;

}
