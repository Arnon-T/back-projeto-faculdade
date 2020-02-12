package com.faculdade.faculdade.boletim;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class BoletimNaoEncontradoException extends Exception {
    public BoletimNaoEncontradoException(String message) {
        super(message);
    }
}
