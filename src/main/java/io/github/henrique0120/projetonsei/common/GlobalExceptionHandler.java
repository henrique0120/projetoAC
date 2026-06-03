package io.github.henrique0120.projetonsei.common;

import io.github.henrique0120.projetonsei.dto.ErroResposta;
import io.github.henrique0120.projetonsei.exception.CPFExistenteException;
import org.springframework.http.HttpStatus;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(CPFExistenteException.class)
    @ResponseStatus(HttpStatus.CONFLICT)
    public ErroResposta handleCPFExistenteException(CPFExistenteException e){

    }

}
