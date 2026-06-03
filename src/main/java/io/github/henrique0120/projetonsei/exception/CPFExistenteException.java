package io.github.henrique0120.projetonsei.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.CONFLICT)
public class CPFExistenteException extends RuntimeException {
    public CPFExistenteException(String message) {
        super(message);
    }
}
