package com.faculdade.faculdade.aluno;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class TelefoneInvalidoException extends Exception {
    public TelefoneInvalidoException(String message) {
        super(message);
    }
}
